package com.spring.service.impl;

import com.spring.DTO.ManufacturerDTO;
import com.spring.DTO.OrderHistoryDTO;
import com.spring.mapper.ManufacturerMapper;
import com.spring.mapper.OrderHistoryMapper;
import com.spring.model.Manufacturer;
import com.spring.repository.ManufacturerRepository;
import com.spring.repository.OrderHistoryRepository;
import com.spring.service.ManufacturerService;
import com.spring.service.OrderHistoryService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {
    private final MapperFacade mapperFacade;
    private final ManufacturerRepository manufacturerRepository;

    @Override
    public ManufacturerDTO getById(Long aLong) {
        return null;
    }

    @Override
    public ManufacturerDTO save(ManufacturerDTO manufacturerDTO) {
        Manufacturer manufacturer = manufacturerRepository.save(mapperFacade.map(manufacturerDTO, Manufacturer.class));
        return mapperFacade.map(manufacturer, ManufacturerDTO.class);
    }

    @Override
    public ManufacturerDTO update(ManufacturerDTO manufacturerDTO) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<ManufacturerDTO> findAll() {
        return mapperFacade.mapAsList(manufacturerRepository.findAll(), ManufacturerDTO.class);
    }
}