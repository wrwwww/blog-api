package org.ml.blog.controller;

import org.ml.blog.common.Result;
import org.ml.blog.domain.dto.TagsDTO;
import org.ml.blog.domain.vo.TagsVO;
import org.ml.blog.domain.vo.PageVO;
import org.ml.blog.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tags")
public class TagsController {
    @Autowired
    private TagsService service;

    @GetMapping("/list")
    public Result<PageVO<TagsVO>> list(@RequestParam int page, @RequestParam int size) {

        return Result.success(service.list(page, size));
    }

    @GetMapping("/{id}")
    public Result<TagsVO> get(@PathVariable String id) {
        return Result.success(service.getById(id));
    }

    @PostMapping
    public Result<?> create(@RequestBody TagsDTO dto) {
        service.create(dto);
        return Result.success(true);
    }

    @PutMapping
    public Result<?> update(@RequestBody TagsDTO dto) {
        service.update(dto);
        return Result.success(true);
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable String id) {
        service.delete(id);
        return Result.success(true);
    }
}
