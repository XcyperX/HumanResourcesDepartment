package com.spring.service.impl;

import com.spring.DTO.CategoriesDTO;
import com.spring.DTO.ProductDTO;
import com.spring.mapper.CategoriesMapper;
import com.spring.mapper.ProductMapper;
import com.spring.repository.CategoriesRepository;
import com.spring.repository.ProductRepository;
import com.spring.service.CategoriesService;
import com.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> findAll() {
        return productMapper.toDtos(productRepository.findAll());
    }

    @Override
    public ProductDTO getById(Long id) {
        if (productRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого продукта!");
        }
        return productMapper.toDto(productRepository.findById(id).get());
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        return productMapper.toDto(productRepository.save(productMapper.toEntity(productDTO)));
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        if (productRepository.findById(productDTO.getId()).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого продукта!");
        }
        return productMapper.toDto(productRepository.save(productMapper.toEntity(productDTO)));
    }

    @Override
    public void delete(Long id) {
        if (productRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого продукта!");
        }
        productRepository.deleteById(id);
    }
}
