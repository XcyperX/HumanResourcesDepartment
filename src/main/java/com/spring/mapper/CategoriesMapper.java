package com.spring.mapper;

import com.spring.DTO.CategoriesDTO;
import com.spring.base.MapperService;
import com.spring.model.Categories;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriesMapper implements MapperService<Categories, CategoriesDTO> {
    @Override
    public Categories toEntity(CategoriesDTO dto) {
        Categories categories = new Categories();
        categories.setId(dto.getId());
        categories.setName(dto.getName());
        return categories;
    }

    @Override
    public CategoriesDTO toDto(Categories entity) {
        CategoriesDTO categoriesDTO = new CategoriesDTO();
        categoriesDTO.setId(entity.getId());
        categoriesDTO.setName(entity.getName());
        return categoriesDTO;
    }

    @Override
    public List<Categories> toEntities(List<CategoriesDTO> dto) {
        List<Categories> categories = new ArrayList<>();
        dto.forEach(subdivisionDTO -> categories.add(toEntity(subdivisionDTO)));
        return categories;
    }

    @Override
    public List<CategoriesDTO> toDtos(List<Categories> entity) {
        List<CategoriesDTO> categoriesDTOS = new ArrayList<>();
        entity.forEach(subdivision -> categoriesDTOS.add(toDto(subdivision)));
        return categoriesDTOS;
    }
}
