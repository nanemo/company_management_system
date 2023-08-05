package com.nanemo.company_management_system.model.map;

import com.nanemo.company_management_system.model.dto.PositionDto;
import com.nanemo.company_management_system.model.dto.UserDto;
import com.nanemo.company_management_system.model.entity.Position;
import com.nanemo.company_management_system.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
@RequiredArgsConstructor
public abstract class UserMapper {
    private final CompanyMapper companyMapper;
    private final PositionMapper positionMapper;

    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "birthDate", source = "birthdate")
    @Mapping(target = "companyDto", expression = "java(companyMapper.toDtoWithActiveYearField(user.getCompany()))")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "positionListDto", expression = "java(positionListToListDto(user.getPositionList()))")
    public abstract UserDto toUserDto(User user);

    protected List<PositionDto> positionListToListDto(List<Position> positionList) {
        return positionList.stream().map(positionMapper::toPositionDto).toList();
    }

}

