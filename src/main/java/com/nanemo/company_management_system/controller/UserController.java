package com.nanemo.company_management_system.controller;

import com.nanemo.company_management_system.model.dto.UserDto;
import com.nanemo.company_management_system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/by_id/{id}")
    public UserDto findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/by_position_name/{position_name}")
    public List<UserDto> findUserById(@PathVariable("position_name") String positionName) {
        return userService.findUsersWithPositionName(positionName);
    }


}
