package com.spring.repository;

import com.spring.model.Categories;
import com.spring.model.Subdivision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubdivisionRepository extends JpaRepository<Subdivision, Long> {
}
