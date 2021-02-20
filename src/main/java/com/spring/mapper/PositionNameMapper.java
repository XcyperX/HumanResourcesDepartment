package com.spring.mapper;

import com.spring.DTO.PositionNameDTO;
import com.spring.base.MapperService;
import com.spring.model.PositionName;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PositionNameMapper implements MapperService<PositionName, PositionNameDTO> {
    @Override
    public PositionName toEntity(PositionNameDTO dto) {
        PositionName PositionName = new PositionName();
        PositionName.setId(dto.getId());
        PositionName.setName(dto.getName());
        return PositionName;
    }

    @Override
    public PositionNameDTO toDto(PositionName entity) {
        PositionNameDTO PositionNameDTO = new PositionNameDTO();
        PositionNameDTO.setId(entity.getId());
        PositionNameDTO.setName(entity.getName());
        return PositionNameDTO;
    }

    @Override
    public List<PositionName> toEntities(List<PositionNameDTO> dto) {
        List<PositionName> positionNames = new ArrayList<>();
        dto.forEach(PositionNameDTO -> positionNames.add(toEntity(PositionNameDTO)));
        return positionNames;
    }

    @Override
    public List<PositionNameDTO> toDtos(List<PositionName> entity) {
        List<PositionNameDTO> positionNameDTOS = new ArrayList<>();
        entity.forEach(PositionName -> positionNameDTOS.add(toDto(PositionName)));
        return positionNameDTOS;
    }
}
