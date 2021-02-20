//package com.spring.mapper;
//
//import com.spring.DTO.SuppliesDTO;
//import com.spring.base.MapperService;
//import com.spring.model.Manufacturer;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class TablesMapper implements MapperService<Manufacturer, SuppliesDTO> {
//    @Override
//    public Manufacturer toEntity(SuppliesDTO dto) {
//        Manufacturer manufacturer = new Manufacturer();
//        manufacturer.setId(dto.getId());
//        manufacturer.setName(dto.getName());
//        return manufacturer;
//    }
//
//    @Override
//    public SuppliesDTO toDto(Manufacturer entity) {
//        SuppliesDTO suppliesDTO = new SuppliesDTO();
//        suppliesDTO.setId(entity.getId());
//        suppliesDTO.setName(entity.getName());
//        return suppliesDTO;
//    }
//
//    @Override
//    public List<Manufacturer> toEntities(List<SuppliesDTO> dto) {
//        List<Manufacturer> tables = new ArrayList<>();
//        dto.forEach(subdivisionDTO -> tables.add(toEntity(subdivisionDTO)));
//        return tables;
//    }
//
//    @Override
//    public List<SuppliesDTO> toDtos(List<Manufacturer> entity) {
//        List<SuppliesDTO> suppliesDTOS = new ArrayList<>();
//        entity.forEach(subdivision -> suppliesDTOS.add(toDto(subdivision)));
//        return suppliesDTOS;
//    }
//}
