package com.spring.service;

import com.spring.DTO.CategoriesDTO;
import com.spring.base.CRUDService;

import java.util.List;

public interface CategoriesService extends CRUDService<CategoriesDTO, Long> {
    List<CategoriesDTO> findAll();
}
