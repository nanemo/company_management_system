package com.nanemo.company_management_system.model.map;

import com.nanemo.company_management_system.model.dto.CompanyDto;
import com.nanemo.company_management_system.model.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class CompanyMapper {

    @Mapping(target = "activeYear", expression = "java(countActiveYear(company))")
    @Mapping(target = "employeeCount", ignore = true)
    public abstract CompanyDto toDtoWithActiveYearField(Company company);

    protected int countActiveYear(Company company) {
        return LocalDate.now().getYear() - company.getCreateDate().getYear();
    }

    public List<CompanyDto> companyListToCompanyDtoList(List<Company> companyList) {
        return companyList.stream().map(this::toDtoWithActiveYearField).toList();
    }

    @Mapping(target = "activeYear", expression = "java(countActiveYear(company))")
    @Mapping(target = "employeeCount", expression = "java(company.getUserList().size())")
    public abstract CompanyDto toDtoWithActiveYearAndEmployeeCountFields(Company company);


}
