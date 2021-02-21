package com.spring.service.impl;

import com.spring.DTO.PositionDTO;
import com.spring.mapper.PositionMapper;
import com.spring.model.Position;
import com.spring.repository.PositionRepository;
import com.spring.service.PositionService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final MapperFacade mapperFacade;
    private final PositionRepository positionRepository;
    @Override
    public PositionDTO getById(Long id) {
        if (positionRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такогой должности!");
        }
        return mapperFacade.map(positionRepository.findById(id).get(), PositionDTO.class);
    }

    @Override
    public PositionDTO save(PositionDTO positionDTO) {
        Position position = positionRepository.save(mapperFacade.map(positionDTO, Position.class));
        return mapperFacade.map(position, PositionDTO.class);
    }

    @Override
    public PositionDTO update(PositionDTO positionDTO) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<PositionDTO> findAll() {
        return mapperFacade.mapAsList(positionRepository.findAll(), PositionDTO.class);
    }
}
