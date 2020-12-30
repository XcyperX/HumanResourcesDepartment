package com.spring.service.impl;

import com.spring.DTO.PositionDTO;
import com.spring.mapper.PositionMapper;
import com.spring.repository.PositionRepository;
import com.spring.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public PositionDTO getById(Long aLong) {
        return null;
    }

    @Override
    public PositionDTO save(PositionDTO positionDTO) {
        return positionMapper.toDto(positionRepository.save(positionMapper.toEntity(positionDTO)));
    }

    @Override
    public PositionDTO update(PositionDTO positionDTO) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
