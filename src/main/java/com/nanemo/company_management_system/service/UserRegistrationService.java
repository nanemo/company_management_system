package com.nanemo.company_management_system.service;

import com.nanemo.company_management_system.model.dto.UserDto;
import com.nanemo.company_management_system.model.entity.User;
import com.nanemo.company_management_system.model.map.UserMapper;
import com.nanemo.company_management_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public Optional<UserDto> findByLogin(UserDto userDto) {
        return Optional.ofNullable(userMapper.toUserDto(userRepository.findUserByLogin(userDto.getLogin()).orElse(null)));
    }

    public void registerUser(UserDto userDto) {
        User user = userMapper.toUserEntity(userDto);

        userRepository.findUserByLogin(user.getLogin());

    }
    
}
