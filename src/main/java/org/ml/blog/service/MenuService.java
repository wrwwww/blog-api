package org.ml.blog.service;

import org.ml.blog.common.ResultCode;
import org.ml.blog.domain.entity.Menu;
import org.ml.blog.domain.dto.MenuDTO;
import org.ml.blog.domain.vo.MenuVO;
import org.ml.blog.domain.vo.PageVO;
import org.ml.blog.exception.BizException;
import org.ml.blog.repository.MenuRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MenuService {
    @Autowired
    MenuRepository dao;

    public PageVO<MenuVO> list(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Menu> all = dao.findAll(pageable);
        List<MenuVO> list = all.stream().map(e -> {
            MenuVO vo = new MenuVO();
            BeanUtils.copyProperties(e, vo);
            return vo;
        }).toList();
        return PageVO.getPageVO(all, list);

    }

    public MenuVO getById(String id) {
        Menu byTypeId = dao.findMenuById(id);
        if (byTypeId == null) {
            return null;
        }
        MenuVO vo = new MenuVO();
        BeanUtils.copyProperties(byTypeId, vo);
        return vo;
    }

    public void create(MenuDTO dto) {
        Menu v = dao.findMenuById(dto.getId());
        if (v != null) {
            throw new BizException(ResultCode.DUPLICATE_DATA);
        }
        Menu vo = new Menu();
        BeanUtils.copyProperties(dto, vo);
        Menu result = dao.save(vo);
    }

    public void update(MenuDTO dto) {
        Menu v = dao.findMenuById(dto.getId());
        if (v == null) {
            throw new BizException(ResultCode.DATA_NO_EXISTS);
        }
        BeanUtils.copyProperties(dto, v);
        Menu result = dao.save(v);
    }

    @Transactional
    public void delete(String id) {
        dao.deleteMenuById(id);
    }
}
