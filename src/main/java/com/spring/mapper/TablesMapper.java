package com.spring.mapper;

import com.spring.DTO.StatusDTO;
import com.spring.DTO.TablesDTO;
import com.spring.base.MapperService;
import com.spring.model.Tables;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TablesMapper implements MapperService<Tables, TablesDTO> {
    @Override
    public Tables toEntity(TablesDTO dto) {
        Tables tables = new Tables();
        tables.setId(dto.getId());
        tables.setName(dto.getName());
        return tables;
    }

    @Override
    public TablesDTO toDto(Tables entity) {
        TablesDTO tablesDTO = new TablesDTO();
        tablesDTO.setId(entity.getId());
        tablesDTO.setName(entity.getName());
        return tablesDTO;
    }

    @Override
    public List<Tables> toEntities(List<TablesDTO> dto) {
        List<Tables> tables = new ArrayList<>();
        dto.forEach(subdivisionDTO -> tables.add(toEntity(subdivisionDTO)));
        return tables;
    }

    @Override
    public List<TablesDTO> toDtos(List<Tables> entity) {
        List<TablesDTO> tablesDTOS = new ArrayList<>();
        entity.forEach(subdivision -> tablesDTOS.add(toDto(subdivision)));
        return tablesDTOS;
    }
}
