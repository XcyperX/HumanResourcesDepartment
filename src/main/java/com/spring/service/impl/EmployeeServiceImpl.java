package com.spring.service.impl;

import com.spring.DTO.EmployeeDTO;
import com.spring.DTO.VacationDateDTO;
import com.spring.mapper.EmployeeMapper;
import com.spring.model.Employee;
import com.spring.repository.EmployeeRepository;
import com.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDTO getById(Long id) {
        if (employeeRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого сотрудника!");
        }
        return employeeMapper.toDto(employeeRepository.findById(id).get());
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        return employeeMapper.toDto(employeeRepository.save(employeeMapper.toEntity(employeeDTO)));
    }

    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO) {
        if (employeeRepository.findById(employeeDTO.getId()).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого сотрудника!");
        }
        employeeRepository.deleteById(employeeDTO.getId());
        return employeeMapper.toDto(employeeRepository.save(employeeMapper.toEntity(employeeDTO)));
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return employeeMapper.toDtos(employeeRepository.findAll());
    }

    @Override
    public EmployeeDTO updateVacationEmployeeById(Long id, VacationDateDTO vacationDateDTO) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Ошибка, нет такого сотрудника!");
        }
        Employee employee = employeeRepository.findById(id).get();
        employee.setVacationStart(vacationDateDTO.getVacationStart());
        employee.setVacationFinal(vacationDateDTO.getVacationFinal());
        employeeRepository.deleteById(id);
        return employeeMapper.toDto(employeeRepository.save(employee));
    }
}
