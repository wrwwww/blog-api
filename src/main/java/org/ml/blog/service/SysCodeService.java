package org.ml.blog.service;

import org.ml.blog.common.ResultCode;
import org.ml.blog.domain.entity.SysCodeType;
import org.ml.blog.domain.entity.SysCodeValue;
import org.ml.blog.domain.vo.SysCodeTypeVO;
import org.ml.blog.domain.vo.SysCodeValueVO;
import org.ml.blog.exception.BizException;
import org.ml.blog.repository.SysCodeTypeRepository;
import org.ml.blog.repository.SysCodeValueRepository;
import org.ml.blog.utils.MyBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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
        List<SysCodeValue> codeValueList = sysCodeValueRepository.findByTypeId(type.getId());
        return MyBeanUtils.copyList(codeValueList, SysCodeValueVO::new);

    }


    @Cacheable(value = "sys_code_type", key = "'list'")
    public List<SysCodeTypeVO> queryList() {
        List<SysCodeType> all = sysCodeTypeRepository.findAll();
        return MyBeanUtils.copyList(all, SysCodeTypeVO::new);

    }
}
