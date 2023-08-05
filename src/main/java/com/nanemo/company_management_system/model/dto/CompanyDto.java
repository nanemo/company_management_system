package com.nanemo.company_management_system.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDto {

    private Long id;

    private String name;

    private LocalDate createDate;

    private int activeYear;

    private int employeeCount;

}
