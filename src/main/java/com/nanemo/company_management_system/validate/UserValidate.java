package com.nanemo.company_management_system.validate;

import com.nanemo.company_management_system.model.dto.UserDto;
import com.nanemo.company_management_system.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class UserValidate implements Validator {

    private final UserRegistrationService userRegistrationService;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        userRegistrationService.findByLogin(userDto)
                .ifPresent(error -> errors.rejectValue("login", "", "Login exists"));
    }

}
