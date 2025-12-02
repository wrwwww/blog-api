package org.ml.blog.service;

import org.ml.blog.common.ResultCode;
import org.ml.blog.domain.entity.Tags;
import org.ml.blog.domain.dto.TagsDTO;
import org.ml.blog.domain.vo.TagsVO;
import org.ml.blog.domain.vo.PageVO;
import org.ml.blog.exception.BizException;
import org.ml.blog.repository.TagsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TagsService {
    @Autowired
    TagsRepository dao;

    public PageVO<TagsVO> list(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Tags> all = dao.findAll(pageable);
        List<TagsVO> list = all.stream().map(e -> {
            TagsVO vo = new TagsVO();
            BeanUtils.copyProperties(e, vo);
            return vo;
        }).toList();
        return PageVO.getPageVO(all, list);

    }

    public TagsVO getById(String id) {
        Tags byTypeId = dao.findTagsById(id);
        if (byTypeId == null) {
            return null;
        }
        TagsVO vo = new TagsVO();
        BeanUtils.copyProperties(byTypeId, vo);
        return vo;
    }

    public void create(TagsDTO dto) {
        Tags v = dao.findTagsById(dto.getId());
        if (v != null) {
            throw new BizException(ResultCode.DUPLICATE_DATA);
        }
        Tags vo = new Tags();
        BeanUtils.copyProperties(dto, vo);
        Tags result = dao.save(vo);
    }

    public void update(TagsDTO dto) {
        Tags v = dao.findTagsById(dto.getId());
        if (v == null) {
            throw new BizException(ResultCode.DATA_NO_EXISTS);
        }
        BeanUtils.copyProperties(dto, v);
        Tags result = dao.save(v);
    }

    @Transactional
    public void delete(String id) {
        dao.deleteTagsById(id);
    }
}
