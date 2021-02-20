package com.spring.service.impl;

import com.spring.DTO.CustomerDTO;
import com.spring.DTO.ManufacturerDTO;
import com.spring.service.CustomerService;
import com.spring.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getById(Long aLong) {
        return null;
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<CustomerDTO> findAll() {
        return null;
    }
}
