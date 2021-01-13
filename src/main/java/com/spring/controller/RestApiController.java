package com.spring.controller;

import com.spring.DTO.*;
import com.spring.model.User;
import com.spring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private SubdivisionService subdivisionService;
    @Autowired
    private AgreementDataService agreementDataService;
    @Autowired
    private PositionNameService positionNameService;

    @PostMapping("/registrations")
    public UserDTO registrationUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @PutMapping("/users/{id}")
    public UserDTO updateUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        return userService.update(userDTO);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @PostMapping("/positions/names")
    public PositionNameDTO createPositionName(@RequestBody @Valid PositionNameDTO positionNameDTO) {
        return positionNameService.save(positionNameDTO);
    }

    @PostMapping("/subdivisions")
    public SubdivisionDTO createSubdivision(@RequestBody @Valid SubdivisionDTO subdivisionDTO) {
        return subdivisionService.save(subdivisionDTO);
    }

    @PostMapping("/employees")
    public EmployeeDTO createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        return employeeService.save(employeeDTO);
    }

    @PutMapping("/employees/{id}")
    public EmployeeDTO createEmployee(@PathVariable("id") Long id, @RequestBody @Valid EmployeeDTO employeeDTO) {
        employeeDTO.setId(id);
        return employeeService.update(employeeDTO);
    }

    @PutMapping("/employees/vacation/{id}")
    public EmployeeDTO updateEmployeeVacation(@PathVariable("id") Long id, @RequestBody @Valid VacationDateDTO vacationDateDTO) {
        return employeeService.updateVacationEmployeeById(id, vacationDateDTO);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.delete(id);
    }

    @GetMapping("/get/employee/{id}")
    public ResponseEntity<?> getRequestById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @PostMapping("/agreements")
    public AgreementDataDTO createAgreement(@RequestBody @Valid AgreementDataDTO agreementDataDTO) {
        return agreementDataService.save(agreementDataDTO);
    }
}
