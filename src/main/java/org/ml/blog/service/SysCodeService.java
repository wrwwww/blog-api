package org.ml.blog.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.ml.blog.common.ResultCode;
import org.ml.blog.domain.entity.SysCodeType;
import org.ml.blog.domain.entity.SysCodeValue;
import org.ml.blog.domain.form.SysCodeTypeForm;
import org.ml.blog.domain.form.SysCodeTypeUpdateForm;
import org.ml.blog.domain.form.SysCodeValueForm;
import org.ml.blog.domain.form.SysCodeValueUpdateForm;
import org.ml.blog.domain.vo.PageVO;
import org.ml.blog.domain.vo.SysCodeTypeVO;
import org.ml.blog.domain.vo.SysCodeValueVO;
import org.ml.blog.exception.BizException;
import org.ml.blog.repository.SysCodeTypeRepository;
import org.ml.blog.repository.SysCodeValueRepository;
import org.ml.blog.utils.MyBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class SysCodeService {

    @Autowired
    SysCodeValueRepository sysCodeValueRepository;
    @Autowired
    SysCodeTypeRepository sysCodeTypeRepository;

    @Cacheable(value = "sys_type", key = "#codeType")
    public List<SysCodeValueVO> queryCode(String codeType) {
        SysCodeType type = sysCodeTypeRepository.findByCodeType(codeType);
        if (type == null) {
            throw new BizException(ResultCode.SYS_ERROR);
        }
        List<SysCodeValue> codeValueList = sysCodeValueRepository.findByCodeType(type.getCodeType());
        return MyBeanUtils.copyList(codeValueList, SysCodeValueVO::new);

    }


    @Cacheable(value = "sys_code_type", key = "'list'")
    public PageVO<SysCodeTypeVO> queryList(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<SysCodeType> all = sysCodeTypeRepository.findAll(pageable);

        List<SysCodeTypeVO> list = all.stream().map(e -> {
            SysCodeTypeVO vo = new SysCodeTypeVO();
            BeanUtils.copyProperties(e, vo);
            return vo;
        }).toList();
        return PageVO.getPageVO(all, list);

    }

    // 删除码表list的缓存
    @CacheEvict(value = "sys_code_type", key = "'list'")
    public SysCodeTypeVO insertSysCodeType(SysCodeTypeForm form) {
        SysCodeType sysCodeType = new SysCodeType();
        BeanUtils.copyProperties(form, sysCodeType);
        SysCodeType byCodeType = sysCodeTypeRepository.findByCodeType(form.getCodeType());
        if (byCodeType != null) {
            throw new BizException(ResultCode.DUPLICATE_DATA);
        }
        SysCodeType result = sysCodeTypeRepository.save(sysCodeType);
        SysCodeTypeVO sysCodeTypeVO = new SysCodeTypeVO();
        BeanUtils.copyProperties(result, sysCodeTypeVO);
        return sysCodeTypeVO;
    }

    //  删除码表缓存
    @Caching(evict = {
            @CacheEvict(value = "sys_code_type", key = "'list'"),
            @CacheEvict(value = "sys_type", key = "#form.codeType")
    })
    public SysCodeTypeVO updateSysCodeType(SysCodeTypeForm form) {
        SysCodeType byCodeType = sysCodeTypeRepository.findByCodeType(form.getCodeType());
        if (byCodeType == null) {
            throw new BizException(ResultCode.DATA_NO_EXISTS);
        }
        BeanUtils.copyProperties(form, byCodeType);
        SysCodeType result = sysCodeTypeRepository.save(byCodeType);
        SysCodeTypeVO sysCodeTypeVO = new SysCodeTypeVO();
        BeanUtils.copyProperties(result, sysCodeTypeVO);
        return sysCodeTypeVO;
    }


    @Caching(evict = {
            @CacheEvict(value = "sys_code_type", key = "'list'"),
            @CacheEvict(value = "sys_type", key = "#codeType")
    })
    @Transactional
    public void delSysCodeType(String codeType) {
        List<SysCodeValue> byTypeId = sysCodeValueRepository.findByCodeType(codeType);
        if (!CollectionUtils.isEmpty(byTypeId)) {
            throw new BizException(ResultCode.EXISTS_SON);
        }
        sysCodeTypeRepository.deleteSysCodeTypesByCodeType(codeType);


    }

    @CacheEvict(value = "sys_type", key = "#form.codeType")
    public SysCodeValueVO insertSysCodeValue(SysCodeValueForm form) {
        SysCodeType byCodeType = sysCodeTypeRepository.findByCodeType(form.getCodeType());
        if (byCodeType == null) {
            throw new BizException(ResultCode.DATA_NO_EXISTS);
        }
        SysCodeValue byCodeValue = sysCodeValueRepository.findByCodeValue((form.getCodeValue()));
        if (byCodeValue != null) {
            throw new BizException(ResultCode.EXISTS_SON);
        }
        SysCodeValue sysCodeValue = new SysCodeValue();
        BeanUtils.copyProperties(form, sysCodeValue);
        SysCodeValue result = sysCodeValueRepository.save(sysCodeValue);
        SysCodeValueVO sysCodeValueVO = new SysCodeValueVO();
        BeanUtils.copyProperties(result, sysCodeValueVO);
        return sysCodeValueVO;
    }


    @CacheEvict(value = "sys_type", key = "#form.codeType")
    public SysCodeValueVO updateSysCodeValue(SysCodeValueUpdateForm form) {
        SysCodeValue sysCodeValueById = sysCodeValueRepository.findSysCodeValueById(form.getId());
        if (sysCodeValueById == null) {
            throw new BizException(ResultCode.DATA_NO_EXISTS);
        }
        BeanUtils.copyProperties(form, sysCodeValueById);
        SysCodeValue result = sysCodeValueRepository.save(sysCodeValueById);
        SysCodeValueVO sysCodeValueVO = new SysCodeValueVO();
        BeanUtils.copyProperties(result, sysCodeValueVO);
        return sysCodeValueVO;

    }

    @CacheEvict(value = "sys_type", key = "#codeType")
    @Transactional
    public void delSysCodeValue(String codeType, String codeValueId) {
        sysCodeValueRepository.deleteSysCodeValueById(codeValueId);
    }
}
