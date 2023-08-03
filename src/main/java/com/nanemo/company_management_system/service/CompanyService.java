package com.nanemo.company_management_system.service;

import com.nanemo.company_management_system.model.dto.CompanyDto;
import com.nanemo.company_management_system.model.map.CompanyMapper;
import com.nanemo.company_management_system.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public List<CompanyDto> findAll() {
        return companyMapper.companyListToCompanyDtoList(companyRepository.findAll());
    }



}
