package com.spring.repository;

import com.spring.model.OrderHistory;
import com.spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
