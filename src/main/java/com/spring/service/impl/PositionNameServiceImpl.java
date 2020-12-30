package com.spring.service.impl;

import com.spring.DTO.PositionNameDTO;
import com.spring.mapper.PositionNameMapper;
import com.spring.repository.PositionNameRepository;
import com.spring.service.PositionNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionNameServiceImpl implements PositionNameService {
    @Autowired
    private PositionNameMapper positionNameMapper;
    @Autowired
    private PositionNameRepository positionNameRepository;
    @Override
    public PositionNameDTO getById(Long aLong) {
        return null;
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
}
