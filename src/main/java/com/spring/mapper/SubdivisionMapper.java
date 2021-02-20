package com.spring.mapper;

import com.spring.DTO.SubdivisionDTO;
import com.spring.base.MapperService;
import com.spring.model.Subdivision;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubdivisionMapper implements MapperService<Subdivision, SubdivisionDTO> {
    @Override
    public Subdivision toEntity(SubdivisionDTO dto) {
        Subdivision subdivision = new Subdivision();
        subdivision.setId(dto.getId());
        subdivision.setName(dto.getName());
        return subdivision;
    }

    @Override
    public SubdivisionDTO toDto(Subdivision entity) {
        SubdivisionDTO subdivisionDTO = new SubdivisionDTO();
        subdivisionDTO.setId(entity.getId());
        subdivisionDTO.setName(entity.getName());
        return subdivisionDTO;
    }

    @Override
    public List<Subdivision> toEntities(List<SubdivisionDTO> dto) {
        List<Subdivision> subdivisions = new ArrayList<>();
        dto.forEach(subdivisionDTO -> subdivisions.add(toEntity(subdivisionDTO)));
        return subdivisions;
    }

    @Override
    public List<SubdivisionDTO> toDtos(List<Subdivision> entity) {
        List<SubdivisionDTO> subdivisionDTOS = new ArrayList<>();
        entity.forEach(subdivision -> subdivisionDTOS.add(toDto(subdivision)));
        return subdivisionDTOS;
    }
}
