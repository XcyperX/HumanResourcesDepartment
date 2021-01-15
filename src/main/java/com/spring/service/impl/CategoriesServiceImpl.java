package com.spring.service.impl;

import com.spring.DTO.CategoriesDTO;
import com.spring.mapper.CategoriesMapper;
import com.spring.repository.CategoriesRepository;
import com.spring.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    @Autowired
    private CategoriesMapper categoriesMapper;
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Override
    public CategoriesDTO getById(Long aLong) {
        return null;
    }

    @Override
    public CategoriesDTO save(CategoriesDTO categoriesDTO) {
        return categoriesMapper.toDto(categoriesRepository.save(categoriesMapper.toEntity(categoriesDTO)));
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
        return categoriesMapper.toDtos(categoriesRepository.findAll());
    }
}
