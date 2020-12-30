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
    private StatusService statusService;
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

    @PostMapping("/statuses")
    public StatusDTO createStatus(@RequestBody @Valid StatusDTO statusDTO) {
        return statusService.save(statusDTO);
    }

    @PostMapping("/positions/names")
    public PositionNameDTO createPositionName(@RequestBody @Valid PositionNameDTO positionNameDTO) {
        return positionNameService.save(positionNameDTO);
    }

    @PostMapping("/subdivision")
    public SubdivisionDTO createSubdivision(@RequestBody @Valid SubdivisionDTO subdivisionDTO) {
        return subdivisionService.save(subdivisionDTO);
    }

    @PostMapping("/employees")
    public EmployeeDTO createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        return employeeService.save(employeeDTO);
    }

//    @PutMapping("/requests/{id}")
//    public RequestDTO updateRequest(@PathVariable("id") Long id, @RequestBody RequestDTO requestDTO) {
//        requestDTO.setId(id);
//        return requestService.update(requestDTO);
//    }
//
//    @PutMapping("/requests/accepted/request/{requestId}")
//    public RequestDTO acceptedRequest(@PathVariable("requestId") Long requestId, @AuthenticationPrincipal User user) {
//        return requestService.acceptedRequestById(requestId, user.getId());
//    }
//
//    @PutMapping("/requests/declined/request/{requestId}")
//    public RequestDTO declinedRequest(@PathVariable("requestId") Long requestId, @AuthenticationPrincipal User user) {
//        return requestService.declinedRequestById(requestId, user.getId());
//    }
//
//    @PutMapping("/requests/performed")
//    public RequestDTO performedRequest(@RequestBody @Valid RequestDTO requestDTO,
//                                       @AuthenticationPrincipal User user) {
//        return requestService.performedRequestById(requestDTO, user.getId());
//    }
//
//    @DeleteMapping("/requests/{id}")
//    public void deleteRequest(@PathVariable("id") Long id) {
//        requestService.delete(id);
//    }
//
//    @GetMapping("/get/requests")
//    public ResponseEntity<?> getRequest() {
//        return ResponseEntity.ok(requestService.findAll());
//    }
//
//    @GetMapping("/get/requests/{id}")
//    public ResponseEntity<?> getRequestById(@PathVariable("id") Long id) {
//        return ResponseEntity.ok(requestService.getById(id));
//    }
//
//    @GetMapping("/users")
//    public ResponseEntity<?> getTeacher() {
//        return ResponseEntity.ok(userService.findAll());
//    }
}
