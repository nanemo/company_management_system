package com.nanemo.company_management_system.model.map;

import com.nanemo.company_management_system.model.dto.PositionDto;
import com.nanemo.company_management_system.model.entity.Position;
import org.mapstruct.Mapper;

@Mapper
public interface PositionMapper {

    PositionDto toPositionDto(Position position);

    Position toPositionEntity(PositionDto positionDto);
}
