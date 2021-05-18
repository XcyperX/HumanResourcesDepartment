package com.spring.service;

import com.spring.DTO.CategoriesDTO;
import com.spring.DTO.ProductDTO;
import com.spring.base.CRUDService;

import java.util.List;

public interface ProductService extends CRUDService<ProductDTO, Long> {
    List<ProductDTO> findAllByUserId(Long id);
    List<ProductDTO> findAllProductsProviders();
    List<ProductDTO> findAllProductsCompany();
    List<ProductDTO> findByParams(List<ProductDTO> list, Long user_id, Long store_id, Long manufacturer_id, Long categories_id, String name);
    List<ProductDTO> findProductsByListId(List<String> product_id);
    Float getPriceProducts(List<String> product_id);
    Integer countProductsProviders();
    Integer countProductsCompany();
    Integer countProductByUserId(Long id);
    Long count();
    ProductDTO findAllProductsCompanyAndId(Long id);
}
