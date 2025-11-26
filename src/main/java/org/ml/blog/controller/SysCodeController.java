package org.ml.blog.controller;

import org.ml.blog.common.Result;
import org.ml.blog.common.ResultCode;
import org.ml.blog.entity.SysCodeType;
import org.ml.blog.entity.SysCodeValue;
import org.ml.blog.exception.BizException;
import org.ml.blog.repository.SysCodeTypeRepository;
import org.ml.blog.repository.SysCodeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys_code")
public class SysCodeController {
    @Autowired
    SysCodeValueRepository sysCodeValueRepository;
    @Autowired
    SysCodeTypeRepository sysCodeTypeRepository;

    @GetMapping("/query")
    public Result<?> queryCode(@RequestParam("codeType") String codeType) {
        SysCodeType type = sysCodeTypeRepository.findByCodeType(codeType);
        if (type == null) {
            throw new BizException(ResultCode.SYS_ERROR);
        }
        List<SysCodeValue> codeValueList = sysCodeValueRepository.findByTypeId(type.getId());

        return Result.success(codeValueList);
    }
}
