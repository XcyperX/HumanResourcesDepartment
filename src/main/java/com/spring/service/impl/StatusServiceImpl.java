//package com.spring.service.impl;
//
//import com.spring.DTO.StatusDTO;
//import com.spring.mapper.StatusMapper;
//import com.spring.repository.StatusRepository;
//import com.spring.service.StatusService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class StatusServiceImpl implements StatusService {
//    @Autowired
//    private StatusMapper statusMapper;
//    @Autowired
//    private StatusRepository statusRepository;
//
//    @Override
//    public List<StatusDTO> findAll() {
//        return null;
//    }
//
//    @Override
//    public StatusDTO getById(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public StatusDTO save(StatusDTO statusDTO) {
//        return statusMapper.toDto(statusRepository.save(statusMapper.toEntity(statusDTO)));
//    }
//
//    @Override
//    public StatusDTO update(StatusDTO statusDTO) {
//        return null;
//    }
//
//    @Override
//    public void delete(Long aLong) {
//
//    }
//}
