package com.spring.service;

import com.spring.DTO.AgreementDataDTO;
import com.spring.base.CRUDService;

import java.util.List;

public interface AgreementDataService extends CRUDService<AgreementDataDTO, Long> {
    List<AgreementDataDTO> findAll();
    List<AgreementDataDTO> findAllByEmployeeId(Long id);
}
