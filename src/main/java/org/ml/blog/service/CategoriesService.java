package org.ml.blog.service;

import org.ml.blog.common.ResultCode;
import org.ml.blog.domain.entity.Categories;
import org.ml.blog.domain.dto.CategoriesDTO;
import org.ml.blog.domain.vo.CategoriesVO;
import org.ml.blog.domain.vo.PageVO;
import org.ml.blog.exception.BizException;
import org.ml.blog.repository.CategoriesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CategoriesService {
    @Autowired
    CategoriesRepository dao;

    public PageVO<CategoriesVO> list(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Categories> all = dao.findAll(pageable);
        List<CategoriesVO> list = all.stream().map(e -> {
            CategoriesVO vo = new CategoriesVO();
            BeanUtils.copyProperties(e, vo);
            return vo;
        }).toList();
        return PageVO.getPageVO(all, list);

    }

    public CategoriesVO getById(String id) {
        Categories byTypeId = dao.findCategoriesById(id);
        if (byTypeId == null) {
            return null;
        }
        CategoriesVO vo = new CategoriesVO();
        BeanUtils.copyProperties(byTypeId, vo);
        return vo;
    }

    public void create(CategoriesDTO dto) {
        Categories v = dao.findCategoriesById(dto.getId());
        if (v != null) {
            throw new BizException(ResultCode.DUPLICATE_DATA);
        }
        Categories vo = new Categories();
        BeanUtils.copyProperties(dto, vo);
        Categories result = dao.save(vo);
    }

    public void update(CategoriesDTO dto) {
        Categories v = dao.findCategoriesById(dto.getId());
        if (v == null) {
            throw new BizException(ResultCode.DATA_NO_EXISTS);
        }
        BeanUtils.copyProperties(dto, v);
        Categories result = dao.save(v);
    }

    @Transactional
    public void delete(String id) {
        dao.deleteCategoriesById(id);
    }
}
