package com.spring.service;

import com.spring.DTO.EmployeeDTO;
import com.spring.DTO.VacationDateDTO;
import com.spring.base.CRUDService;

import java.util.List;

public interface EmployeeService extends CRUDService<EmployeeDTO, Long> {
    List<EmployeeDTO> findAll();
    EmployeeDTO updateVacationEmployeeById(Long id, VacationDateDTO vacationDateDTO);
}
