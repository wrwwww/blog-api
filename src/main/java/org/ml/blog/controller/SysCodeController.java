package org.ml.blog.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.ml.blog.common.Result;
import org.ml.blog.common.ResultCode;
import org.ml.blog.domain.entity.SysCodeType;
import org.ml.blog.domain.vo.SysCodeTypeVO;
import org.ml.blog.domain.vo.SysCodeValueVO;
import org.ml.blog.exception.BizException;
import org.ml.blog.service.SysCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys_code")
@Tag(name = "码表", description = "码表的API")
public class SysCodeController {

    @Autowired
    SysCodeService sysCodeService;

    @GetMapping("/query")
    @Operation(summary = "获取码表值", description = "返回指定码表类型的值")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "404", description = "未找到用户")
    })
    public Result<?> queryCode(@RequestParam("codeType") @Parameter(name = "codeType") String codeType) {
        if (codeType == null || codeType.isEmpty()) {
            throw new BizException(ResultCode.PARAM_LOST);
        }
        List<SysCodeValueVO> sysCodeValueVOS = sysCodeService.queryCode(codeType);
        return Result.success(sysCodeValueVOS);
    }

    @GetMapping("query_list")
    public Result<List<SysCodeTypeVO>> queryTypeList() {
        List<SysCodeTypeVO> sysCodeTypes = sysCodeService.queryList();
        return Result.success(sysCodeTypes);
    }
}
