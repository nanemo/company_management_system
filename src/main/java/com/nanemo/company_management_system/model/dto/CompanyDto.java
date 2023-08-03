package com.nanemo.company_management_system.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Getter
@Setter
@NoArgsConstructor
public class CompanyDto {

    private Long id;

    private String name;

    private LocalDate createDate;

    private int activeYear;

}
