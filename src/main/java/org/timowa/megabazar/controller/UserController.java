package org.timowa.megabazar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.timowa.megabazar.dto.user.UserInfoDto;
import org.timowa.megabazar.service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{id}")
    public UserInfoDto findById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public PagedModel<UserInfoDto> getAllUsers(Pageable pageable) {
        Page<UserInfoDto> userPage = userService.findAll(pageable);
        return new PagedModel<>(userPage);
    }
}