package com.spring.service.impl;

import com.spring.DTO.CustomerDTO;
import com.spring.DTO.ManufacturerDTO;
import com.spring.model.Customer;
import com.spring.repository.CustomerRepository;
import com.spring.service.CustomerService;
import com.spring.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final MapperFacade mapperFacade;
    private final CustomerRepository customerRepository;

    @Override
    public CustomerDTO getById(Long id) {
        if (customerRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого покупателя!");
        }
        return null;
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        Customer customer = customerRepository.save(mapperFacade.map(customerDTO, Customer.class));
        return mapperFacade.map(customer, CustomerDTO.class);
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {

        return null;
    }

    @Override
    public void delete(Long id) {
        if (customerRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого покупателя!");
        }
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerDTO> findAll() {
        return mapperFacade.mapAsList(customerRepository.findAll(), CustomerDTO.class);
    }
}
