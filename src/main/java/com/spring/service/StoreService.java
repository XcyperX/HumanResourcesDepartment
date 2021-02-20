package com.spring.service;

import com.spring.DTO.StoreDTO;
import com.spring.DTO.SuppliesDTO;
import com.spring.base.CRUDService;

import java.util.List;

public interface StoreService extends CRUDService<StoreDTO, Long> {
    List<StoreDTO> findAllByUsersId(Long id);
    List<StoreDTO> findAllByIsProvide(Boolean bool);
}
