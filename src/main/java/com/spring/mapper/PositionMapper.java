package com.spring.mapper;

import com.spring.DTO.PositionDTO;
import com.spring.base.MapperService;
import com.spring.model.Position;
import com.spring.model.PositionName;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PositionMapper implements MapperService<Position, PositionDTO> {
    @Override
    public Position toEntity(PositionDTO dto) {
        Position position = new Position();
        position.setId(dto.getId());
        position.setPositionName(new PositionName(dto.getPositionNameId()));
        position.setDateReceipt(dto.getDateReceipt());
        position.setDateDismissal(dto.getDateDismissal());
        return position;
    }

    @Override
    public PositionDTO toDto(Position entity) {
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setId(entity.getId());
        positionDTO.setPositionNameId(entity.getPositionName().getId());
        positionDTO.setDateReceipt(entity.getDateReceipt());
        positionDTO.setDateDismissal(entity.getDateDismissal());
        return positionDTO;
    }

    @Override
    public List<Position> toEntities(List<PositionDTO> dto) {
        List<Position> positions = new ArrayList<>();
        dto.forEach(positionDTO -> positions.add(toEntity(positionDTO)));
        return positions;
    }

    @Override
    public List<PositionDTO> toDtos(List<Position> entity) {
        List<PositionDTO> positionDTOS = new ArrayList<>();
        entity.forEach(position -> positionDTOS.add(toDto(position)));
        return positionDTOS;
    }
}
