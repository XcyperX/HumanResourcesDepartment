package com.spring.service;

import com.spring.DTO.PositionDTO;
import com.spring.base.CRUDService;

import java.util.List;

public interface PositionService extends CRUDService<PositionDTO, Long> {
    List<PositionDTO> findAll();
}
