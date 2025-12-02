package org.ml.blog.controller;

import org.ml.blog.common.Result;
import org.ml.blog.domain.dto.MenuDTO;
import org.ml.blog.domain.vo.MenuVO;
import org.ml.blog.domain.vo.PageVO;
import org.ml.blog.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    private MenuService service;

    @GetMapping("/list")
    public Result<PageVO<MenuVO>> list(@RequestParam int page, @RequestParam int size) {

        return Result.success(service.list(page, size));
    }

    @GetMapping("/{id}")
    public Result<MenuVO> get(@PathVariable String id) {
        return Result.success(service.getById(id));
    }

    @PostMapping
    public Result<?> create(@RequestBody MenuDTO dto) {
        service.create(dto);
        return Result.success(true);
    }

    @PutMapping
    public Result<?> update(@RequestBody MenuDTO dto) {
        service.update(dto);
        return Result.success(true);
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable String id) {
        service.delete(id);
        return Result.success(true);
    }
}
