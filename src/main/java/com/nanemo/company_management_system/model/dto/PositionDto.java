package com.nanemo.company_management_system.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@NoArgsConstructor
public class PositionDto {

    private Long id;

    private String name;

    private List<UserDto> userDtoList;
}
