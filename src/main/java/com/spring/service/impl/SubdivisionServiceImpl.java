package com.spring.service.impl;

import com.spring.DTO.SubdivisionDTO;
import com.spring.model.Subdivision;
import com.spring.repository.SubdivisionRepository;
import com.spring.service.SubdivisionService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubdivisionServiceImpl implements SubdivisionService {
    private final MapperFacade mapperFacade;
    private final SubdivisionRepository subdivisionRepository;

    @Override
    public SubdivisionDTO getById(Long aLong) {
        return null;
    }

    @Override
    public SubdivisionDTO save(SubdivisionDTO subdivisionDTO) {
        Subdivision subdivision = subdivisionRepository.save(mapperFacade.map(subdivisionDTO, Subdivision.class));
        return mapperFacade.map(subdivision, SubdivisionDTO.class);
    }

    @Override
    public SubdivisionDTO update(SubdivisionDTO subdivisionDTO) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<SubdivisionDTO> findAll() {
        return mapperFacade.mapAsList(subdivisionRepository.findAll(), SubdivisionDTO.class);
    }
}
