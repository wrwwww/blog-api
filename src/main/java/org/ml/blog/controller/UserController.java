package org.ml.blog.controller;

import org.ml.blog.common.Result;
import org.ml.blog.domain.dto.UserDTO;
import org.ml.blog.domain.vo.UserVO;
import org.ml.blog.domain.vo.PageVO;
import org.ml.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/list")
    public Result<PageVO<UserVO>> list(@RequestParam int page, @RequestParam int size) {
        return Result.success(service.list(page, size));
    }

    @GetMapping("/{id}")
    public Result<UserVO> get(@PathVariable String id) {
        return Result.success(service.getById(id));
    }

    @PostMapping
    public Result<?> create(@RequestBody UserDTO dto) {
        service.create(dto);
        return Result.success(true);
    }

    @PutMapping
    public Result<?> update(@RequestBody UserDTO dto) {
        service.update(dto);
        return Result.success(true);
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable String id) {
        service.delete(id);
        return Result.success(true);
    }
}
