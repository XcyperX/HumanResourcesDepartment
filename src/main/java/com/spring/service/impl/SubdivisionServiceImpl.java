package com.spring.service.impl;

import com.spring.DTO.SubdivisionDTO;
import com.spring.mapper.SubdivisionMapper;
import com.spring.repository.SubdivisionRepository;
import com.spring.service.SubdivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubdivisionServiceImpl implements SubdivisionService {
    @Autowired
    private SubdivisionMapper subdivisionMapper;
    @Autowired
    private SubdivisionRepository subdivisionRepository;
    @Override
    public SubdivisionDTO getById(Long aLong) {
        return null;
    }

    @Override
    public SubdivisionDTO save(SubdivisionDTO subdivisionDTO) {
        return subdivisionMapper.toDto(subdivisionRepository.save(subdivisionMapper.toEntity(subdivisionDTO)));
    }

    @Override
    public SubdivisionDTO update(SubdivisionDTO subdivisionDTO) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
