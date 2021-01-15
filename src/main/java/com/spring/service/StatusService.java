package com.spring.service;

import com.spring.DTO.CategoriesDTO;
import com.spring.DTO.StatusDTO;
import com.spring.base.CRUDService;

import java.util.List;

public interface StatusService extends CRUDService<StatusDTO, Long> {
    List<StatusDTO> findAll();
}
