package com.spring.repository;

import com.spring.model.OrderHistory;
import com.spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByUserId(Long id);
    List<Product> findAllByStoreId(Long id);
    Integer countAllByUserId(Long id);
    Integer countProductByUserId(Long id);
}
