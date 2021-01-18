package com.spring.mapper;

import com.spring.DTO.ProductDTO;
import com.spring.base.MapperService;
import com.spring.model.Categories;
import com.spring.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper implements MapperService<Product, ProductDTO> {
    @Override
    public Product toEntity(ProductDTO dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setCategories(new Categories(dto.getCategoriesId()));
        product.setStructure(dto.getStructure());
        product.setPrice(dto.getPrice());
        return product;
    }

    @Override
    public ProductDTO toDto(Product entity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(entity.getId());
        productDTO.setName(entity.getName());
        productDTO.setDescription(entity.getDescription());
        productDTO.setCategoriesId(entity.getCategories().getId());
        productDTO.setStructure(entity.getStructure());
        productDTO.setPrice(entity.getPrice());
        return productDTO;
    }

    @Override
    public List<Product> toEntities(List<ProductDTO> dto) {
        List<Product> products = new ArrayList<>();
        dto.forEach(productDTO -> products.add(toEntity(productDTO)));
        return products;
    }

    @Override
    public List<ProductDTO> toDtos(List<Product> entity) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        entity.forEach(product -> productDTOS.add(toDto(product)));
        return productDTOS;
    }
}
