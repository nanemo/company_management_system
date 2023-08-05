package com.nanemo.company_management_system.controller;

import com.nanemo.company_management_system.model.dto.CompanyDto;
import com.nanemo.company_management_system.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public CompanyDto findById(@PathVariable Long id) {
        return companyService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    public void createCompany(@Valid @RequestBody CompanyDto companyDto) {
        companyService.saveCompany(companyDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // 200
    public void updateCompany(@Valid @RequestBody CompanyDto companyDto, @PathVariable Long id) {
        companyService.updateCompany(companyDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
    }

}
