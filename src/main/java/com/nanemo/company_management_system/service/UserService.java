package com.nanemo.company_management_system.service;

import com.nanemo.company_management_system.model.dto.UserDto;
import com.nanemo.company_management_system.model.entity.User;
import com.nanemo.company_management_system.model.map.UserMapper;
import com.nanemo.company_management_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserDto).toList();
    }

    public UserDto findUserById(Long id) {
        return userMapper.toUserDto(userRepository.findById(id).orElse(null));
    }


    public List<UserDto> findUsersWithPositionName(String positionName) {
        List<User> usersWithPositionName = userRepository.findUsersWithPositionName(positionName);
        System.out.println(usersWithPositionName + "-----------");

        return userMapper.userListToUserDtoList(usersWithPositionName);
    }
}
