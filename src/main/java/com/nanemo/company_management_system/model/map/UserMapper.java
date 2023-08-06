package com.nanemo.company_management_system.model.map;

import com.nanemo.company_management_system.model.dto.UserDto;
import com.nanemo.company_management_system.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

import static com.nanemo.company_management_system.model.map.PositionMapper.userMapper;

@Mapper(imports = UserMapper.class)
public interface UserMapper {
    CompanyMapper companyMapper = Mappers.getMapper(CompanyMapper.class);
    PositionMapper positionMapper = Mappers.getMapper(PositionMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "birthDate", source = "birthdate")
    @Mapping(target = "companyDto", expression = "java(companyMapper.toDtoWithActiveYearField(user.getCompany()))")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "positionListDto", expression = "java(positionMapper.positionListToListDtoWithoutUserDtoList(user.getPositionList()))")
    UserDto toUserDto(User user);

    default List<UserDto> userListToUserDtoList(List<User> userList) {
        return userList.stream().map(userMapper::toUserDto).toList();
    }

}

