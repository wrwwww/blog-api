package org.ml.blog.controller;

import org.ml.blog.common.Result;
import org.ml.blog.domain.dto.ArticlesDTO;
import org.ml.blog.domain.vo.ArticlesVO;
import org.ml.blog.domain.vo.PageVO;
import org.ml.blog.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles")
public class ArticlesController {
    @Autowired
    private ArticlesService service;

    @GetMapping("/list")
    public Result<PageVO<ArticlesVO>> list(@RequestParam int page, @RequestParam int size) {
        return Result.success(service.list(page, size));
    }

    @GetMapping("/{id}")
    public Result<ArticlesVO> get(@PathVariable String id) {
        return Result.success(service.getById(id));
    }

    @PostMapping
    public Result<?> create(@RequestBody ArticlesDTO dto) {
        service.create(dto);
        return Result.success(true);
    }

    @PutMapping
    public Result<?> update(@RequestBody ArticlesDTO dto) {
        service.update(dto);
        return Result.success(true);
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable String id) {
        service.delete(id);
        return Result.success(true);
    }
}
