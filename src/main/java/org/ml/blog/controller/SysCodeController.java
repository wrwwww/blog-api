package org.ml.blog.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.ml.blog.common.Result;
import org.ml.blog.common.ResultCode;
import org.ml.blog.domain.dto.SysCodeTypeDTO;
import org.ml.blog.domain.dto.SysCodeValueDTO;
import org.ml.blog.domain.dto.SysCodeValueUpdateDTO;
import org.ml.blog.domain.vo.SysCodeTypeVO;
import org.ml.blog.domain.vo.SysCodeValueVO;
import org.ml.blog.exception.BizException;
import org.ml.blog.service.SysCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sys_code")
@Tag(name = "码表", description = "码表的API")
public class SysCodeController {

    @Autowired
    SysCodeService service;

    @GetMapping("/list")
    @Operation(summary = "码表列表", description = "返回所有的码表类型列表")
    public Result<List<SysCodeTypeVO>> list() {
        return Result.success(service.list());
    }

    @PostMapping
    @Operation(summary = "添加码表类型", description = "添加新的码表类型")
    public Result<?> insertSysCodeType(@RequestBody @Valid SysCodeTypeDTO form) {
        SysCodeTypeVO sysCodeTypeVO = service.insertSysCodeType(form);
        return Result.success(sysCodeTypeVO);
    }

    @PutMapping
    @Operation(summary = "更新码表类型", description = "更新码表类型")
    public Result<?> updateSysCodeType(@RequestBody @Valid SysCodeTypeDTO form) {
        SysCodeTypeVO sysCodeTypeVO = service.updateSysCodeType(form);
        return Result.success(sysCodeTypeVO);
    }

    @DeleteMapping("/{codeType}")
    @Operation(summary = "删除码表类型", description = "删除码表类型")
    public Result<Boolean> delSysCodeType(@PathVariable("codeType") @Valid @NotNull String codeType) {
        service.delSysCodeType(codeType);
        return Result.success(true);
    }

    @GetMapping("/value/{codeType}")
    @Operation(summary = "获取码表值", description = "返回指定码表类型的值")
    public Result<?> queryCode(@PathVariable("codeType") @Parameter(name = "codeType") String codeType) {
        if (codeType == null || codeType.isEmpty()) {
            throw new BizException(ResultCode.PARAM_LOST);
        }
        List<SysCodeValueVO> sysCodeValueVOS = service.queryCode(codeType);
        return Result.success(sysCodeValueVOS);
    }

    @PostMapping("/value")
    @Operation(summary = "添加码表值", description = "添加新的码表类型")
    public Result<?> insertSysCodeValue(@RequestBody @Valid SysCodeValueDTO dto) {
        SysCodeValueVO sysCodevalueVO = service.insertSysCodeValue(dto);
        return Result.success(sysCodevalueVO);
    }

    @PutMapping("/value")
    @Operation(summary = "更新码表值", description = "更新码表值")
    public Result<?> updateSysCodeValue(@RequestBody @Valid SysCodeValueUpdateDTO dto) {
        SysCodeValueVO sysCodeValueVO = service.updateSysCodeValue(dto);
        return Result.success(sysCodeValueVO);
    }

    @DeleteMapping("/value/{codeValueId}")
    @Operation(summary = "删除码表值", description = "删除码表值")
    public Result<Boolean> delSysCodeValue(@PathVariable("codeValueId") @Valid @NotNull String codeValueId) {
        service.delSysCodeValue(codeValueId);
        return Result.success(true);
    }


}
