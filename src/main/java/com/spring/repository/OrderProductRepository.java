package com.spring.repository;
import com.spring.model.OrderProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProductInfo, Long> {
}
