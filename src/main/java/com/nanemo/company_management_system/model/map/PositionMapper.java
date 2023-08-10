package com.nanemo.company_management_system.model.map;

import com.nanemo.company_management_system.model.dto.PositionDto;
import com.nanemo.company_management_system.model.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PositionMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "userDtoList", ignore = true)
    PositionDto toPositionDto(Position position);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "userList", ignore = true)
    Position toPositionEntity(PositionDto positionDto);

    default List<PositionDto> positionListToListDtoWithoutUserDtoList(List<Position> positionList) {
        return positionList.stream().map(this::toPositionDto).toList();
    }

    default List<Position> positionDtoListToEntityList(List<PositionDto> positionDtoList) {
        return positionDtoList.stream().map(this::toPositionEntity).toList();
    }

}
