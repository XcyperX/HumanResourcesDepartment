package com.spring.service.impl;

import com.spring.DTO.PassportDTO;
import com.spring.model.Passport;
import com.spring.repository.PassportRepository;
import com.spring.service.PassportService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService {
    private final PassportRepository passportRepository;
    private final MapperFacade mapperFacade;
    @Override
    public PassportDTO getById(Long aLong) {
        return null;
    }

    @Override
    public PassportDTO save(PassportDTO passportDTO) {
        Passport passport = passportRepository.save(mapperFacade.map(passportDTO, Passport.class));
        return mapperFacade.map(passport, PassportDTO.class);
    }

    @Override
    public PassportDTO update(PassportDTO passportDTO) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<PassportDTO> findAll() {
        return null;
    }
}
