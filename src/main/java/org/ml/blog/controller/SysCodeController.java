package org.ml.blog.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.ml.blog.common.Result;
import org.ml.blog.common.ResultCode;
import org.ml.blog.domain.form.SysCodeTypeForm;
import org.ml.blog.domain.form.SysCodeValueForm;
import org.ml.blog.domain.form.SysCodeValueUpdateForm;
import org.ml.blog.domain.vo.PageVO;
import org.ml.blog.domain.vo.SysCodeTypeVO;
import org.ml.blog.domain.vo.SysCodeValueVO;
import org.ml.blog.exception.BizException;
import org.ml.blog.service.SysCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys_code")
@Tag(name = "码表", description = "码表的API")
public class SysCodeController {

    @Autowired
    SysCodeService sysCodeService;

    @GetMapping("/query")
    @Operation(summary = "码表列表", description = "返回所有的码表类型列表")
    public Result<PageVO<SysCodeTypeVO>> queryTypeList() {
        PageVO<SysCodeTypeVO> sysCodeTypes = sysCodeService.queryList(0,10);
        return Result.success(sysCodeTypes);

    }

    @PostMapping("/insert")
    @Operation(summary = "添加码表类型", description = "添加新的码表类型")
    public Result<?> insertSysCodeType(@RequestBody @Valid SysCodeTypeForm form) {
        SysCodeTypeVO sysCodeTypeVO = sysCodeService.insertSysCodeType(form);
        return Result.success(sysCodeTypeVO);
    }

    @PutMapping("/update")
    @Operation(summary = "更新码表类型", description = "更新码表类型")
    public Result<?> updateSysCodeType(@RequestBody @Valid SysCodeTypeForm form) {
        SysCodeTypeVO sysCodeTypeVO = sysCodeService.updateSysCodeType(form);
        return Result.success(sysCodeTypeVO);
    }

    @DeleteMapping("/delete/{codeType}")
    @Operation(summary = "删除码表类型", description = "删除码表类型")
    public Result<Boolean> delSysCodeType(@PathVariable("codeType") @Valid @NotNull String codeType) {
        sysCodeService.delSysCodeType(codeType);
        return Result.success(true);
    }

    @GetMapping("/value/query/{codeType}")
    @Operation(summary = "获取码表值", description = "返回指定码表类型的值")
    public Result<?> queryCode(@PathVariable("codeType") @Parameter(name = "codeType") String codeType) {
        if (codeType == null || codeType.isEmpty()) {
            throw new BizException(ResultCode.PARAM_LOST);
        }
        List<SysCodeValueVO> sysCodeValueVOS = sysCodeService.queryCode(codeType);
        return Result.success(sysCodeValueVOS);
    }
    @PostMapping("/value/insert")
    @Operation(summary = "添加码表值", description = "添加新的码表类型")
    public Result<?> insertSysCodeValue(@RequestBody @Valid SysCodeValueForm form) {
        SysCodeValueVO sysCodevalueVO = sysCodeService.insertSysCodeValue(form);
        return Result.success(sysCodevalueVO);
    }

    @PutMapping("/value/update")
    @Operation(summary = "更新码表值", description = "更新码表值")
    public Result<?> updateSysCodeValue(@RequestBody @Valid SysCodeValueUpdateForm form) {
        SysCodeValueVO sysCodeValueVO = sysCodeService.updateSysCodeValue(form);
        return Result.success(sysCodeValueVO);
    }

    @DeleteMapping("/value/delete/{codeType}/{codeValueId}")
    @Operation(summary = "删除码表值", description = "删除码表值")
    public Result<Boolean> delSysCodeValue(@PathVariable("codeType") @Valid @NotNull String codeType,@PathVariable("codeValueId") @Valid @NotNull String codeValueId) {
        sysCodeService.delSysCodeValue(codeType,codeValueId);
        return Result.success(true);
    }



}
