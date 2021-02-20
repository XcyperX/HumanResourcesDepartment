package com.spring.service.impl;

import com.spring.DTO.CategoriesDTO;
import com.spring.model.Categories;
import com.spring.repository.CategoriesRepository;
import com.spring.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {
    private final MapperFacade mapperFacade;
    private final CategoriesRepository categoriesRepository;

    @Override
    public CategoriesDTO getById(Long aLong) {
        return null;
    }

    @Override
    public CategoriesDTO save(CategoriesDTO categoriesDTO) {
        Categories categories = categoriesRepository.save(mapperFacade.map(categoriesDTO, Categories.class));
        return mapperFacade.map(categories, CategoriesDTO.class);
    }

    @Override
    public CategoriesDTO update(CategoriesDTO categoriesDTO) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<CategoriesDTO> findAll() {
        return mapperFacade.mapAsList(categoriesRepository.findAll(), CategoriesDTO.class);
    }
}
