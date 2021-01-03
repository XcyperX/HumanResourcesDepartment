package com.spring.service.impl;

import com.spring.DTO.PositionNameDTO;
import com.spring.mapper.PositionNameMapper;
import com.spring.repository.PositionNameRepository;
import com.spring.service.PositionNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionNameServiceImpl implements PositionNameService {
    @Autowired
    private PositionNameMapper positionNameMapper;
    @Autowired
    private PositionNameRepository positionNameRepository;
    @Override
    public PositionNameDTO getById(Long id) {
        if (positionNameRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такогой должности!");
        }
        return positionNameMapper.toDto(positionNameRepository.findById(id).get());
    }

    @Override
    public PositionNameDTO save(PositionNameDTO positionNameDTO) {
        return positionNameMapper.toDto(positionNameRepository.save(positionNameMapper.toEntity(positionNameDTO)));
    }

    @Override
    public PositionNameDTO update(PositionNameDTO positionNameDTO) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<PositionNameDTO> findAll() {
        return positionNameMapper.toDtos(positionNameRepository.findAll());
    }
}
