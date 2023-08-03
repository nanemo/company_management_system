package com.nanemo.company_management_system.model.map;

import com.nanemo.company_management_system.model.dto.CompanyDto;
import com.nanemo.company_management_system.model.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CompanyMapper {
    @Mapping(target = "activeYear", ignore = true)
    CompanyDto companyToCompanyDto(Company company);


    @Mapping(target = "userList", ignore = true)
    Company toEntity(CompanyDto companyDto);

}
