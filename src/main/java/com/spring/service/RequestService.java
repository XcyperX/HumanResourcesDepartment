//package com.spring.service;
//
//import com.spring.webcontent.DTO.EmployeeDTO;
//import com.spring.webcontent.base.CRUDService;
//
//import java.util.List;
//
//public interface RequestService extends CRUDService<EmployeeDTO, Long> {
//    List<EmployeeDTO> findAll();
//    EmployeeDTO acceptedRequestById(Long requestId, Long userId);
//    EmployeeDTO declinedRequestById(Long requestId, Long userId);
//    EmployeeDTO performedRequestById(EmployeeDTO requestDTO, Long userId);
//    List<EmployeeDTO> getRequestsByManager();
//}
