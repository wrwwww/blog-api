package org.ml.blog.service;

import org.ml.blog.common.ResultCode;
import org.ml.blog.domain.entity.Articles;
import org.ml.blog.domain.dto.ArticlesDTO;
import org.ml.blog.domain.vo.ArticlesVO;
import org.ml.blog.domain.vo.PageVO;
import org.ml.blog.exception.BizException;
import org.ml.blog.repository.ArticlesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ArticlesService {
    @Autowired
    ArticlesRepository dao;

    public PageVO<ArticlesVO> list(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Articles> all = dao.findAll(pageable);
        List<ArticlesVO> list = all.stream().map(e -> {
            ArticlesVO vo = new ArticlesVO();
            BeanUtils.copyProperties(e, vo);
            return vo;
        }).toList();
        return PageVO.getPageVO(all, list);

    }

    public ArticlesVO getById(String id) {
        Articles byTypeId = dao.findArticlesById(id);
        if (byTypeId == null) {
            return null;
        }
        ArticlesVO vo = new ArticlesVO();
        BeanUtils.copyProperties(byTypeId, vo);
        return vo;
    }

    public void create(ArticlesDTO dto) {
        Articles v = dao.findArticlesById(dto.getId());
        if (v != null) {
            throw new BizException(ResultCode.DUPLICATE_DATA);
        }
        Articles vo = new Articles();
        BeanUtils.copyProperties(dto, vo);
        Articles result = dao.save(vo);
    }

    public void update(ArticlesDTO dto) {
        Articles v = dao.findArticlesById(dto.getId());
        if (v == null) {
            throw new BizException(ResultCode.DATA_NO_EXISTS);
        }
        BeanUtils.copyProperties(dto, v);
        Articles result = dao.save(v);
    }

    @Transactional
    public void delete(String id) {
        dao.deleteArticlesById(id);
    }
}
