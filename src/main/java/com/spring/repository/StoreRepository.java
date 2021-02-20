package com.spring.repository;

import com.spring.model.Categories;
import com.spring.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findAllByUsersId(Long id);
    List<Store> findAllByIsProvide(Boolean bool);
}
