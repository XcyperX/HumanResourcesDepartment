package com.spring.mapper;

import com.spring.DTO.CategoriesDTO;
import com.spring.DTO.ManufacturerDTO;
import com.spring.base.MapperService;
import com.spring.model.Categories;
import com.spring.model.Manufacturer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManufacturerMapper implements MapperService<Manufacturer, ManufacturerDTO> {
    @Override
    public Manufacturer toEntity(ManufacturerDTO dto) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(dto.getId());
        manufacturer.setName(dto.getName());
        return manufacturer;
    }

    @Override
    public ManufacturerDTO toDto(Manufacturer entity) {
        ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
        manufacturerDTO.setId(entity.getId());
        manufacturerDTO.setName(entity.getName());
        return manufacturerDTO;
    }

    @Override
    public List<Manufacturer> toEntities(List<ManufacturerDTO> dto) {
        List<Manufacturer> manufacturers = new ArrayList<>();
        dto.forEach(manufacturerDTO -> manufacturers.add(toEntity(manufacturerDTO)));
        return manufacturers;
    }

    @Override
    public List<ManufacturerDTO> toDtos(List<Manufacturer> entity) {
        List<ManufacturerDTO> manufacturerDTOS = new ArrayList<>();
        entity.forEach(manufacturer -> manufacturerDTOS.add(toDto(manufacturer)));
        return manufacturerDTOS;
    }
}
