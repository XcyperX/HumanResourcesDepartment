package com.spring.service.impl;

import com.spring.DTO.ProductDTO;
import com.spring.model.Product;
import com.spring.repository.ProductRepository;
import com.spring.service.ProductService;
import com.spring.service.StoreService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return mapperFacade.mapAsList(products, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> findAllProductsCompany() {
        List<ProductDTO> products = new ArrayList<>();
        storeService.findAllByIsProvide(false).forEach(storeDTO -> {
            products.addAll(storeDTO.getProducts());
        });
        return mapperFacade.mapAsList(products, ProductDTO.class);
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
    public List<ProductDTO> findByParams(List<ProductDTO> list, Long user_id, Long store_id, Long manufacturer_id, Long categories_id, String name) {
//        List<ProductDTO> productFiltered = mapperFacade.mapAsList(productRepository.findAllByUserId(user_id), ProductDTO.class);
        List<ProductDTO> productFiltered = list;
        if (user_id != null) {
            productFiltered = mapperFacade.mapAsList(productRepository.findAllByUserId(user_id), ProductDTO.class);
        }
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
        return productFiltered;
    }

    @Override
    public List<ProductDTO> findProductsByListId(List<String> product_id) {
        List<ProductDTO> products = new ArrayList<>();
        if (!product_id.isEmpty()) {
            product_id.forEach(p -> {
                products.add(getById(Long.valueOf(p)));
            });
        } else {
            return products;
        }
        return products;
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
