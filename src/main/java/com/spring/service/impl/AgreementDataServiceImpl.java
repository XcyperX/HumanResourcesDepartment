package com.spring.service.impl;

import com.spring.DTO.AgreementDataDTO;
import com.spring.mapper.AgreementDataMapper;
import com.spring.repository.AgreementDataRepository;
import com.spring.service.AgreementDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgreementDataServiceImpl implements AgreementDataService {
    @Autowired
    private AgreementDataMapper agreementDataMapper;
    @Autowired
    private AgreementDataRepository agreementDataRepository;

    @Override
    public List<AgreementDataDTO> findAll() {
        return agreementDataMapper.toDtos(agreementDataRepository.findAll());
    }

    @Override
    public List<AgreementDataDTO> findAllByEmployeeId(Long id) {
        return agreementDataMapper.toDtos(agreementDataRepository.findAllByEmployeeId(id));
    }

    @Override
    public AgreementDataDTO getById(Long id) {
        if (agreementDataRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого подряда!");
        }
        return agreementDataMapper.toDto(agreementDataRepository.findById(id).get());
    }

    @Override
    public AgreementDataDTO save(AgreementDataDTO agreementDataDTO) {
        return agreementDataMapper.toDto(agreementDataRepository.save(agreementDataMapper.toEntity(agreementDataDTO)));
    }

    @Override
    public AgreementDataDTO update(AgreementDataDTO agreementDataDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {
        if (agreementDataRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого подряда!");
        }
        agreementDataRepository.deleteById(id);
    }
}
