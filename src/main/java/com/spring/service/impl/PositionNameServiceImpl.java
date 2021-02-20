package com.spring.service.impl;

import com.spring.DTO.PositionNameDTO;
import com.spring.model.PositionName;
import com.spring.repository.PositionNameRepository;
import com.spring.service.PositionNameService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionNameServiceImpl implements PositionNameService {
    private final PositionNameRepository positionNameRepository;
    private final MapperFacade mapperFacade;

    @Override
    public PositionNameDTO getById(Long id) {
        if (positionNameRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такогой должности!");
        }
        return mapperFacade.map(positionNameRepository.findById(id).get(), PositionNameDTO.class);
    }

    @Override
    public PositionNameDTO save(PositionNameDTO positionNameDTO) {
        PositionName positionName = positionNameRepository.save(mapperFacade.map(positionNameDTO, PositionName.class));
        return mapperFacade.map(positionName, PositionNameDTO.class);
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
        return mapperFacade.mapAsList(positionNameRepository.findAll(), PositionNameDTO.class);
    }
}
