package com.spring.repository;

import com.spring.model.Status;
import com.spring.model.Tables;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TablesRepository extends JpaRepository<Tables, Long> {
}
