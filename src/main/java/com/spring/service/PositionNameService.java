package com.spring.service;

import com.spring.DTO.PositionNameDTO;
import com.spring.base.CRUDService;

import java.util.List;

public interface PositionNameService extends CRUDService<PositionNameDTO, Long> {
    List<PositionNameDTO> findAll();
}
