package com.nanemo.company_management_system.controller;

import com.nanemo.company_management_system.model.dto.CompanyDto;
import com.nanemo.company_management_system.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    public List<CompanyDto> findAll() {
        return companyService.findAll();
    }

}
