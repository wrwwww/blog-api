package org.ml.blog.controller;

import org.ml.blog.common.Result;
import org.ml.blog.domain.dto.CategoriesDTO;
import org.ml.blog.domain.vo.CategoriesVO;
import org.ml.blog.domain.vo.PageVO;
import org.ml.blog.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    @Autowired
    private CategoriesService service;

    @GetMapping("/list")
    public Result<PageVO<CategoriesVO>> list(@RequestParam int page, @RequestParam int size) {
        return Result.success(service.list(page, size));
    }

    @GetMapping("/{id}")
    public Result<CategoriesVO> get(@PathVariable String id) {
        return Result.success(service.getById(id));
    }

    @PostMapping
    public Result<?> create(@RequestBody CategoriesDTO dto) {
        service.create(dto);
        return Result.success(true);
    }

    @PutMapping
    public Result<?> update(@RequestBody CategoriesDTO dto) {
        service.update(dto);
        return Result.success(true);
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable String id) {
        service.delete(id);
        return Result.success(true);
    }
}
