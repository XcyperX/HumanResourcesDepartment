package com.spring.mapper;

import com.spring.DTO.EmployeeDTO;
import com.spring.base.MapperService;
import com.spring.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper implements MapperService<Employee, EmployeeDTO> {
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private PassportMapper passportMapper;
    @Override
    public Employee toEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setAddress(addressMapper.toEntity(dto.getAddress()));
        employee.setNumberINN(dto.getNumberINN());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setDateBirth(dto.getDateBirth());
        employee.setGender(Gender.valueOf(dto.getGender()));
        employee.setPosition(positionMapper.toEntity(dto.getPosition()));
        employee.setSubdivision(new Subdivision(dto.getSubdivisionId()));
        employee.setStatus(new Status(dto.getStatusId()));
        employee.setPassport(passportMapper.toEntity(dto.getPassport()));
        return employee;
    }

    @Override
    public EmployeeDTO toDto(Employee entity) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(entity.getId());
        employeeDTO.setFirstName(entity.getFirstName());
        employeeDTO.setLastName(entity.getLastName());
        employeeDTO.setAddress(addressMapper.toDto(entity.getAddress()));
        employeeDTO.setNumberINN(entity.getNumberINN());
        employeeDTO.setEmail(entity.getEmail());
        employeeDTO.setPhone(entity.getPhone());
        employeeDTO.setDateBirth(entity.getDateBirth());
        employeeDTO.setGender(entity.getGender().getNameGender());
        employeeDTO.setPosition(positionMapper.toDto(entity.getPosition()));
        employeeDTO.setSubdivisionId(entity.getSubdivision().getId());
        employeeDTO.setStatusId(entity.getStatus().getId());
        employeeDTO.setPassport(passportMapper.toDto(entity.getPassport()));
        return employeeDTO;
    }

    @Override
    public List<Employee> toEntities(List<EmployeeDTO> dto) {
        List<Employee> employees = new ArrayList<>();
        dto.forEach(EmployeeDTO -> employees.add(toEntity(EmployeeDTO)));
        return employees;
    }

    @Override
    public List<EmployeeDTO> toDtos(List<Employee> entity) {
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        entity.forEach(Employee -> employeeDTOS.add(toDto(Employee)));
        return employeeDTOS;
    }
}
