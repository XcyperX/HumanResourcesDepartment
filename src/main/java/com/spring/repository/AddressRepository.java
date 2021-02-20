package com.spring.repository;

import com.spring.model.Address;
import com.spring.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
