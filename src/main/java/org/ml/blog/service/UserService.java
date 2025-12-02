package org.ml.blog.service;

import org.ml.blog.common.ResultCode;
import org.ml.blog.domain.entity.User;
import org.ml.blog.domain.dto.UserDTO;
import org.ml.blog.domain.vo.UserVO;
import org.ml.blog.domain.vo.PageVO;
import org.ml.blog.exception.BizException;
import org.ml.blog.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserService {
    @Autowired
    UserRepository dao;

    public PageVO<UserVO> list(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> all = dao.findAll(pageable);
        List<UserVO> list = all.stream().map(e -> {
            UserVO vo = new UserVO();
            BeanUtils.copyProperties(e, vo);
            return vo;
        }).toList();
        return PageVO.getPageVO(all, list);

    }

    public UserVO getById(String id) {
        User byTypeId = dao.findUserById(id);
        if (byTypeId == null) {
            return null;
        }
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(byTypeId, vo);
        return vo;
    }

    public void create(UserDTO dto) {
        User v = dao.findUserById(dto.getId());
        if (v != null) {
            throw new BizException(ResultCode.DUPLICATE_DATA);
        }
        User vo = new User();
        BeanUtils.copyProperties(dto, vo);
        User result = dao.save(vo);
    }

    public void update(UserDTO dto) {
        User v = dao.findUserById(dto.getId());
        if (v == null) {
            throw new BizException(ResultCode.DATA_NO_EXISTS);
        }
        BeanUtils.copyProperties(dto, v);
        User result = dao.save(v);
    }

    @Transactional
    public void delete(String id) {
        dao.deleteUserById(id);
    }
}
