package org.ml.blog.service;

import org.ml.blog.common.ResultCode;
import org.ml.blog.domain.entity.Logs;
import org.ml.blog.domain.dto.LogsDTO;
import org.ml.blog.domain.vo.LogsVO;
import org.ml.blog.domain.vo.PageVO;
import org.ml.blog.exception.BizException;
import org.ml.blog.repository.LogsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class LogsService {
    @Autowired
    LogsRepository dao;

    public PageVO<LogsVO> list(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Logs> all = dao.findAll(pageable);
        List<LogsVO> list = all.stream().map(e -> {
            LogsVO vo = new LogsVO();
            BeanUtils.copyProperties(e, vo);
            return vo;
        }).toList();
        return PageVO.getPageVO(all, list);

    }

    public LogsVO getById(String id) {
        Logs byTypeId = dao.findLogsById(id);
        if (byTypeId == null) {
            return null;
        }
        LogsVO vo = new LogsVO();
        BeanUtils.copyProperties(byTypeId, vo);
        return vo;
    }

    public void create(LogsDTO dto) {
        Logs v = dao.findLogsById(dto.getId());
        if (v != null) {
            throw new BizException(ResultCode.DUPLICATE_DATA);
        }
        Logs vo = new Logs();
        BeanUtils.copyProperties(dto, vo);
        Logs result = dao.save(vo);
    }

    public void update(LogsDTO dto) {
        Logs v = dao.findLogsById(dto.getId());
        if (v == null) {
            throw new BizException(ResultCode.DATA_NO_EXISTS);
        }
        BeanUtils.copyProperties(dto, v);
        Logs result = dao.save(v);
    }

    @Transactional
    public void delete(String id) {
        dao.deleteLogsById(id);
    }
}
