package com.spring.service.impl;

import com.spring.DTO.EmployeeDTO;
import com.spring.mapper.EmployeeMapper;
import com.spring.repository.EmployeeRepository;
import com.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDTO getById(Long aLong) {
        return null;
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        return employeeMapper.toDto(employeeRepository.save(employeeMapper.toEntity(employeeDTO)));
    }

    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
