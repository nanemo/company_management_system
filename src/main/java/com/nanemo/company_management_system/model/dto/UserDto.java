package com.nanemo.company_management_system.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String login;

    private String password;

    private String role;

    private LocalDate birthDate;

    private CompanyDto companyDto;

    private String email;

    private List<PositionDto> positionListDto;

}
