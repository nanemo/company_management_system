package com.nanemo.company_management_system.model.map;

import com.nanemo.company_management_system.model.dto.UserDto;
import com.nanemo.company_management_system.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(imports = UserMapper.class)
public interface UserMapper {
    CompanyMapper companyMapper = Mappers.getMapper(CompanyMapper.class);
    PositionMapper positionMapper = Mappers.getMapper(PositionMapper.class);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "companyDto", expression = "java(companyMapper.toDtoWithActiveYearField(user.getCompany()))")
    @Mapping(target = "positionListDto", expression = "java(positionMapper.positionListToListDtoWithoutUserDtoList(user.getPositionList()))")
    UserDto toUserDto(User user);

    default List<UserDto> userListToUserDtoList(List<User> userList) {
        return userList.stream().map(this::toUserDto).toList();
    }

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "company", source = "companyDto")
    @Mapping(target = "positionList", expression = "java(positionMapper.positionDtoListToEntityList(userDto.getPositionListDto()))")
    User toUserEntity(UserDto userDto);


}

