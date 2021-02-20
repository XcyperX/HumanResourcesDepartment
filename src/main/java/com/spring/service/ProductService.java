package com.spring.service;

import com.spring.DTO.CategoriesDTO;
import com.spring.DTO.ProductDTO;
import com.spring.base.CRUDService;

import java.util.List;

public interface ProductService extends CRUDService<ProductDTO, Long> {
//    List<ProductDTO> findAll();
    List<ProductDTO> findAllByUserId(Long id);
    Integer countAllByUserId(Long id);
    Long count();
}
