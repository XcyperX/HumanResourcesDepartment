package com.spring.repository;

import com.spring.model.OrderHistory;
import com.spring.model.Role;
import com.spring.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
    List<OrderHistory> findAllByCustomerNotNullOrUserRole(Role role);
    List<OrderHistory> findAllByUserRole(Role roles);
}
