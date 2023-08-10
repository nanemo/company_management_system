package com.nanemo.company_management_system.controller;

import com.nanemo.company_management_system.model.dto.UserDto;
import com.nanemo.company_management_system.service.UserRegistrationService;
import com.nanemo.company_management_system.validate.UserValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserValidate userValidate;
    private final UserRegistrationService registrationService;

    @GetMapping("/login")
    public String login(){
        return "auth/login";
    }

    @Secured({"USER", "ADMIN"})
    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") UserDto userDto, ModelMap modelMap) {
        modelMap.addAttribute("user", userDto);
        return "auth/registration";
    }

    @Secured({"USER", "ADMIN"})
    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public String registerUser(@ModelAttribute("user") UserDto userDto,
                               BindingResult bindingResult) {
        userValidate.validate(userDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "redirect:/auth/registration";
        }

        registrationService.registerUser(userDto);

        return "user/user_list";
    }

}
