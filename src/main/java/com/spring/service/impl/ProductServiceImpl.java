package com.spring.service.impl;

import com.spring.DTO.ProductDTO;
import com.spring.model.Product;
import com.spring.model.Role;
import com.spring.model.User;
import com.spring.repository.ProductRepository;
import com.spring.service.ProductService;
import com.spring.service.StoreService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final MapperFacade mapperFacade;
    private final ProductRepository productRepository;
    private final StoreService storeService;

    @Override
    public List<ProductDTO> findAll() {

        return convertImage(mapperFacade.mapAsList(productRepository.findAll(), ProductDTO.class));
    }

    @Override
    public ProductDTO getById(Long id) {
        if (productRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого продукта!");
        }
        Product product = productRepository.findById(id).get();
        product.setBase64Image(Base64.getEncoder().encodeToString(product.getImage()));
        return mapperFacade.map(product, ProductDTO.class);
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = mapperFacade.map(productDTO, Product.class);
        product.setImage(productDTO.getImage());
//        product.setBase64Image(Base64.getEncoder().encodeToString(productDTO.getImage()));
        productRepository.save(product);
        return mapperFacade.map(product, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> convertImage(List<ProductDTO> productDTOS) {
        productDTOS.forEach(productDTO -> {
            productDTO.setBase64Image(Base64.getEncoder().encodeToString(productDTO.getImage()));
        });
        return productDTOS;
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        if (productRepository.findById(productDTO.getId()).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого продукта!");
        }
        Product product = mapperFacade.map(productDTO, Product.class);
        product.setImage(productDTO.getImage());
        productRepository.save(product);
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
        return convertImage(mapperFacade.mapAsList(productRepository.findAllByUserId(id), ProductDTO.class));
    }

    @Override
    public Integer countProductByUserId(Long id) {
        return productRepository.countProductByUserId(id);
    }

    @Override
    public Long count() {
        return productRepository.count();
    }

    @Override
    public List<ProductDTO> findAllProductsProviders() {
        List<ProductDTO> products = new ArrayList<>();
        storeService.findAllByIsProvide(true).forEach(storeDTO -> {
            products.addAll(storeDTO.getProducts());
        });
        return convertImage(mapperFacade.mapAsList(products, ProductDTO.class));
    }

    @Override
    public List<ProductDTO> findAllProductsCompany() {
        List<ProductDTO> products = new ArrayList<>();
        storeService.findAllByIsProvide(false).forEach(storeDTO -> {
            products.addAll(storeDTO.getProducts());
        });
        return convertImage(mapperFacade.mapAsList(products, ProductDTO.class));
    }

    @Override
    public ProductDTO findAllProductsCompanyAndId(Long id) {
        List<ProductDTO> products = new ArrayList<>();
        storeService.findAllByIsProvide(false).forEach(storeDTO -> {
            products.addAll(storeDTO.getProducts());
        });
        for (ProductDTO product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Integer countProductsProviders() {
        List<ProductDTO> products = new ArrayList<>();
        storeService.findAllByIsProvide(true).forEach(storeDTO -> {
            products.addAll(storeDTO.getProducts());
        });
        return products.size();
    }

    @Override
    public Integer countProductsCompany() {
        List<ProductDTO> products = new ArrayList<>();
        storeService.findAllByIsProvide(false).forEach(storeDTO -> {
            products.addAll(storeDTO.getProducts());
        });
        return products.size();
    }

    @Override
    public List<ProductDTO> findByParams(List<ProductDTO> list, User user, Long store_id, Long manufacturer_id, Long categories_id, String name) {
        List<ProductDTO> productFiltered = list;
        if (user != null && user.getId() != null && user.getId() != 0) {
            productFiltered = mapperFacade.mapAsList(productRepository.findAllByUserId(user.getId()), ProductDTO.class);
            if (user.getRole() != null && !user.getRole().equals(Role.STOREKEEPER))
            productFiltered = mapperFacade.mapAsList(productRepository.findAllByUserId(user.getId()), ProductDTO.class);
        }
//        if (user.getId() != null) {
//            productFiltered = mapperFacade.mapAsList(productRepository.findAllByUserId(user.getId()), ProductDTO.class);
//        }
        if (store_id != 0) {
            productFiltered = productFiltered.stream().filter(productDTO -> productDTO.getStoreId().equals(store_id)).collect(Collectors.toList());
        }
        if (manufacturer_id != 0) {
            productFiltered = productFiltered.stream().filter(productDTO -> productDTO.getManufacturerId().equals(manufacturer_id)).collect(Collectors.toList());
        }
        if (categories_id != 0) {
            productFiltered = productFiltered.stream().filter(productDTO -> productDTO.getCategoriesId().equals(categories_id)).collect(Collectors.toList());
        }
        if (!name.isEmpty()) {
            productFiltered = productFiltered.stream().filter(productDTO -> productDTO.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
        }
        return convertImage(productFiltered);
    }

    @Override
    public List<ProductDTO> findProductsByListId(List<String> product_id) {
        List<ProductDTO> products = new ArrayList<>();
        if (!product_id.isEmpty()) {
            product_id.forEach(p -> {
                products.add(getById(Long.valueOf(p)));
            });
        } else {
            return convertImage(products);
        }
        return convertImage(products);
    }

    @Override
    public Float getPriceProducts(List<String> product_id) {
        Float price = 0F;
        if (!product_id.isEmpty()) {
            for (String p : product_id) {
                price += getById(Long.valueOf(p)).getPrice();
            }
        } else {
            return 0F;
        }
        return price;
    }
}
