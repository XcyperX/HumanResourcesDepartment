package com.spring.repository;

import com.spring.model.Categories;
import com.spring.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
