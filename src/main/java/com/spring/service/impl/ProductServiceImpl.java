package com.spring.service.impl;

import com.spring.DTO.ProductDTO;
import com.spring.model.Product;
import com.spring.repository.ProductRepository;
import com.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final MapperFacade mapperFacade;
    private final ProductRepository productRepository;

    @Override
    public List<ProductDTO> findAll() {
        return mapperFacade.mapAsList(productRepository.findAll(), ProductDTO.class);
    }

    @Override
    public ProductDTO getById(Long id) {
        if (productRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого продукта!");
        }
        return mapperFacade.map(productRepository.findById(id).get(), ProductDTO.class);
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = productRepository.save(mapperFacade.map(productDTO, Product.class));
        return mapperFacade.map(product, ProductDTO.class);
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        if (productRepository.findById(productDTO.getId()).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого продукта!");
        }
        Product product = productRepository.save(mapperFacade.map(productDTO, Product.class));
        return mapperFacade.map(product, ProductDTO.class);
    }

    @Override
    public void delete(Long id) {
        if (productRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого товара!");
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> findAllByUserId(Long id) {
        return mapperFacade.mapAsList(productRepository.findAllByUserId(id), ProductDTO.class);
    }

    @Override
    public Integer countAllByUserId(Long id) {
        return productRepository.countAllByUserId(id);
    }

    @Override
    public Long count() {
        return productRepository.count();
    }
}
