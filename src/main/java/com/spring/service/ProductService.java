package com.spring.service;

import com.spring.DTO.CategoriesDTO;
import com.spring.DTO.ProductDTO;
import com.spring.base.CRUDService;

import java.util.List;

public interface ProductService extends CRUDService<ProductDTO, Long> {
    List<ProductDTO> findAllByUserId(Long id);
    List<ProductDTO> findAllProductsProviders();
    List<ProductDTO> findAllProductsCompany();
    Integer countProductsProviders();
    Integer countProductsCompany();
    Integer countProductByUserId(Long id);
    Long count();
}
