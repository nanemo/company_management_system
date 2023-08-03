package com.nanemo.company_management_system.model.map;

import com.nanemo.company_management_system.model.dto.CompanyDto;
import com.nanemo.company_management_system.model.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface CompanyMapper {
    @Mapping(target = "activeYear", expression = "java(countActiveYear(company))")
    CompanyDto toDto(Company company);


    @Mapping(target = "userList", ignore = true)
    Company toEntity(CompanyDto companyDto);

    default List<CompanyDto> companyListToCompanyDtoList(List<Company> companyList) {
        return companyList.stream().map(this::toDto).collect(Collectors.toList());
    }

    default int countActiveYear(Company company) {
        return LocalDate.now().getYear() - company.getCreateDate().getYear();
    }

}
