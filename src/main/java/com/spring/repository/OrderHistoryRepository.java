package com.spring.repository;

import com.spring.model.OrderHistory;
import com.spring.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
}
