package com.nanemo.company_management_system.model.map;

import com.nanemo.company_management_system.model.dto.CompanyDto;
import com.nanemo.company_management_system.model.entity.Company;
import org.mapstruct.Mapper;

@Mapper
public interface CompanyMapper {

    CompanyDto toDto(Company company);

    @Mapper()
    Company toEntity(CompanyDto companyDto);

}
