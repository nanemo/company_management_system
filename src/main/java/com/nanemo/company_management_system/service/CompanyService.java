package com.nanemo.company_management_system.service;

import com.nanemo.company_management_system.model.dto.CompanyDto;
import com.nanemo.company_management_system.model.entity.Company;
import com.nanemo.company_management_system.model.map.CompanyMapper;
import com.nanemo.company_management_system.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public List<CompanyDto> findAll() {
        return companyMapper.companyListToCompanyDtoList(companyRepository.findAll());
    }


    public CompanyDto findById(Long id) {
        return companyMapper.toDtoWithActiveYearAndEmployeeCountFields(companyRepository.findById(id)
                .orElse(null));
    }

    @Transactional
    public void saveCompany(CompanyDto companyDto) {
        Optional<Company> byName = companyRepository.findByName(companyMapper.companyDtoToEntity(companyDto).getName());

        if (byName.isEmpty()) {
            companyRepository.save(companyMapper.companyDtoToEntity(companyDto));
        }

    }

    @Transactional
    public void updateCompany(CompanyDto companyDto, Long id) {
        companyDto.setId(id);
        companyRepository.save(companyMapper.companyDtoToEntity(companyDto));
    }

    @Transactional
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

}
