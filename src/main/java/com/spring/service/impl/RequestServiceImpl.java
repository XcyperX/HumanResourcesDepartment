//package com.spring.service.impl;
//
//import com.spring.webcontent.DTO.EmployeeDTO;
//import com.spring.webcontent.mapper.RequestMapper;
//import com.spring.webcontent.model.Request;
//import com.spring.webcontent.model.Status;
//import com.spring.webcontent.model.User;
//import com.spring.webcontent.repository.EmployeeRepository;
//import com.spring.webcontent.service.RequestService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class RequestServiceImpl implements RequestService {
//    @Autowired
//    private EmployeeRepository requestRepository;
//    @Autowired
//    private RequestMapper requestMapper;
//
//    @Override
//    public EmployeeDTO getById(Long id) {
//        if (requestRepository.findById(id).isEmpty()) {
//            throw new RuntimeException("Ошибка, нет такой заявки!");
//        }
//        return requestMapper.toDto(requestRepository.findById(id).get());
//    }
//
//    @Override
//    public EmployeeDTO save(EmployeeDTO requestDTO) {
//        return requestMapper.toDto(requestRepository.save(requestMapper.toEntity(requestDTO)));
//    }
//
//    @Override
//    public EmployeeDTO update(EmployeeDTO requestDTO) {
//        if (requestRepository.findById(requestDTO.getId()).isEmpty()) {
//            throw new RuntimeException("Ошибка, нет такой заявки!");
//        }
//        return requestMapper.toDto(requestRepository.save(requestMapper.toEntity(requestDTO)));
//    }
//
//    @Override
//    public void delete(Long id) {
//        if (requestRepository.findById(id).isEmpty()) {
//            throw new RuntimeException("Ошибка, нет такой заявки!");
//        }
//        requestRepository.deleteById(id);
//    }
//
//    @Override
//    public List<EmployeeDTO> findAll() {
//        return requestMapper.toDtos(requestRepository.findAll());
//    }
//
//    @Override
//    public EmployeeDTO acceptedRequestById(Long requestId, Long userId) {
//        Optional<Request> requestOptional = requestRepository.findById(requestId);
//        if (requestOptional.isEmpty()) {
//            throw new RuntimeException("Ошибка, нет такой заявки!");
//        }
//        Request request = requestRepository.findById(requestId).get();
//        request.setStatus(Status.ACCEPTED);
//        request.setUser(new User(userId));
//        request.setDateReception(LocalDate.now());
//        return requestMapper.toDto(requestRepository.save(request));
//    }
//
//    @Override
//    public EmployeeDTO declinedRequestById(Long requestId, Long userId) {
//        Optional<Request> requestOptional = requestRepository.findById(requestId);
//        if (requestOptional.isEmpty()) {
//            throw new RuntimeException("Ошибка, нет такой заявки!");
//        }
//        Request request = requestRepository.findById(requestId).get();
//        request.setStatus(Status.DECLINED);
//        request.setUser(new User(userId));
//        return requestMapper.toDto(requestRepository.save(request));
//    }
//
//    @Override
//    public EmployeeDTO performedRequestById(EmployeeDTO requestDTO, Long userId) {
//        Optional<Request> requestOptional = requestRepository.findById(requestDTO.getId());
//        if (requestOptional.isEmpty()) {
//            throw new RuntimeException("Ошибка, нет такой заявки!");
//        }
//        Request request = requestRepository.findById(requestDTO.getId()).get();
//        request.setStatus(Status.PERFORMED);
//        request.setUser(new User(userId));
//        request.setPrice(requestDTO.getPrice());
//        request.setDateCompletion(LocalDate.now());
//        return requestMapper.toDto(requestRepository.save(request));
//    }
//
//    @Override
//    public List<EmployeeDTO> getRequestsByManager() {
//        return requestMapper.toDtos(requestRepository.findAllByStatus(Status.PERFORMED));
//    }
//}
