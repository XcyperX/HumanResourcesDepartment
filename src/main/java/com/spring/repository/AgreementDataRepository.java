package com.spring.repository;

import com.spring.model.AgreementData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgreementDataRepository extends JpaRepository<AgreementData, Long> {
    List<AgreementData> findAllByEmployeeId(Long id);
}
