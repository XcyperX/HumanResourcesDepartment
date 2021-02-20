package com.spring.repository;

import com.spring.model.Categories;
import com.spring.model.Supplies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppliesRepository extends JpaRepository<Supplies, Long> {
}
