//package com.spring.mapper;
//
//import com.spring.webcontent.DTO.EmployeeDTO;
//import com.spring.webcontent.base.MapperService;
//import com.spring.webcontent.model.Request;
//import com.spring.webcontent.model.Status;
//import com.spring.webcontent.model.Types;
//import com.spring.webcontent.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class RequestMapper implements MapperService<Request, EmployeeDTO> {
//    @Autowired
//    private AddressMapper addressMapper;
//    @Override
//    public Request toEntity(EmployeeDTO dto) {
//        Request request = new Request();
//        request.setId(dto.getId());
//        request.setAddress(addressMapper.toEntity(dto.getAddressDTOS()));
//        request.setEmail(dto.getEmail());
//        request.setPhone(dto.getPhone());
//        request.setDescription(dto.getDescription());
//        request.setTypes(Types.valueOf(dto.getTypes()));
//        request.setStatus(Status.valueOf(dto.getStatus()));
//        request.setPrice(dto.getPrice());
//        if (dto.getUserId() != null) {
//            request.setUser(new User(dto.getUserId()));
//        }
//        request.setDateCompletion(dto.getDateCompletion());
//        request.setDateCreate(LocalDate.now());
//        request.setDateReception(dto.getDateReception());
//        return request;
//    }
//
//    @Override
//    public EmployeeDTO toDto(Request entity) {
//        EmployeeDTO requestDTO = new EmployeeDTO();
//        requestDTO.setId(entity.getId());
//        requestDTO.setAddressDTOS(addressMapper.toDto(entity.getAddress()));
//        requestDTO.setEmail(entity.getEmail());
//        requestDTO.setPhone(entity.getPhone());
//        requestDTO.setDescription(entity.getDescription());
//        requestDTO.setTypes(entity.getTypes().getNameType());
//        requestDTO.setStatus(entity.getStatus().getNameStatus());
//        requestDTO.setPrice(entity.getPrice());
//        if (entity.getUser() != null) {
//            requestDTO.setUserId(entity.getUser().getId());
//        }
//        requestDTO.setDateCompletion(entity.getDateCompletion());
//        requestDTO.setDateCreate(LocalDate.now());
//        requestDTO.setDateReception(entity.getDateReception());
//        return requestDTO;
//    }
//
//    @Override
//    public List<Request> toEntities(List<EmployeeDTO> dto) {
//        List<Request> requests = new ArrayList<>();
//        dto.forEach(requestDTO -> requests.add(toEntity(requestDTO)));
//        return requests;
//    }
//
//    @Override
//    public List<EmployeeDTO> toDtos(List<Request> entity) {
//        List<EmployeeDTO> requestDTOS = new ArrayList<>();
//        entity.forEach(request -> requestDTOS.add(toDto(request)));
//        return requestDTOS;
//    }
//}
