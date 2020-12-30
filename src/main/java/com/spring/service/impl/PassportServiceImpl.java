package com.spring.service.impl;

import com.spring.DTO.PassportDTO;
import com.spring.mapper.PassportMapper;
import com.spring.repository.PassportRepository;
import com.spring.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassportServiceImpl implements PassportService {
    @Autowired
    private PassportRepository passportRepository;
    @Autowired
    private PassportMapper passportMapper;
    @Override
    public PassportDTO getById(Long aLong) {
        return null;
    }

    @Override
    public PassportDTO save(PassportDTO passportDTO) {
        return passportMapper.toDto(passportRepository.save(passportMapper.toEntity(passportDTO)));
    }

    @Override
    public PassportDTO update(PassportDTO passportDTO) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
