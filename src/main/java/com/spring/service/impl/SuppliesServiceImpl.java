package com.spring.service.impl;

import com.spring.DTO.SuppliesDTO;
import com.spring.repository.ManufacturerRepository;
import com.spring.service.SuppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliesServiceImpl implements SuppliesService {
    @Override
    public SuppliesDTO getById(Long aLong) {
        return null;
    }

    @Override
    public SuppliesDTO save(SuppliesDTO suppliesDTO) {
        return null;
    }

    @Override
    public SuppliesDTO update(SuppliesDTO suppliesDTO) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<SuppliesDTO> findAll() {
        return null;
    }
}
