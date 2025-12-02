package org.ml.blog.controller;

import org.ml.blog.common.Result;
import org.ml.blog.domain.dto.RoleDTO;
import org.ml.blog.domain.vo.RoleVO;
import org.ml.blog.domain.vo.PageVO;
import org.ml.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleService service;

    @GetMapping("/list")
    public Result<PageVO<RoleVO>> list(@RequestParam int page, @RequestParam int size) {

        return Result.success(service.list(page, size));
    }

    @GetMapping("/{id}")
    public Result<RoleVO> get(@PathVariable String id) {
        return Result.success(service.getById(id));
    }

    @PostMapping
    public Result<?> create(@RequestBody RoleDTO dto) {
        service.create(dto);
        return Result.success(true);
    }

    @PutMapping
    public Result<?> update(@RequestBody RoleDTO dto) {
        service.update(dto);
        return Result.success(true);
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable String id) {
        service.delete(id);
        return Result.success(true);
    }
}
