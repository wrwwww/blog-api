package org.ml.blog.service;

import org.ml.blog.common.ResultCode;
import org.ml.blog.domain.entity.Role;
import org.ml.blog.domain.dto.RoleDTO;
import org.ml.blog.domain.vo.RoleVO;
import org.ml.blog.domain.vo.PageVO;
import org.ml.blog.exception.BizException;
import org.ml.blog.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RoleService {
    @Autowired
    RoleRepository dao;

    public PageVO<RoleVO> list(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Role> all = dao.findAll(pageable);
        List<RoleVO> list = all.stream().map(e -> {
            RoleVO vo = new RoleVO();
            BeanUtils.copyProperties(e, vo);
            return vo;
        }).toList();
        return PageVO.getPageVO(all, list);

    }

    public RoleVO getById(String id) {
        Role byTypeId = dao.findRoleById(id);
        if (byTypeId == null) {
            return null;
        }
        RoleVO vo = new RoleVO();
        BeanUtils.copyProperties(byTypeId, vo);
        return vo;
    }

    public void create(RoleDTO dto) {
        Role v = dao.findRoleById(dto.getId());
        if (v != null) {
            throw new BizException(ResultCode.DUPLICATE_DATA);
        }
        Role vo = new Role();
        BeanUtils.copyProperties(dto, vo);
        Role result = dao.save(vo);
    }

    public void update(RoleDTO dto) {
        Role v = dao.findRoleById(dto.getId());
        if (v == null) {
            throw new BizException(ResultCode.DATA_NO_EXISTS);
        }
        BeanUtils.copyProperties(dto, v);
        Role result = dao.save(v);
    }

    @Transactional
    public void delete(String id) {
        dao.deleteRoleById(id);
    }
}
