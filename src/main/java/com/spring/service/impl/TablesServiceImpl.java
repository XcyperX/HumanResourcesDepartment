package com.spring.service.impl;

import com.spring.DTO.TablesDTO;
import com.spring.mapper.TablesMapper;
import com.spring.repository.TablesRepository;
import com.spring.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TablesServiceImpl implements TablesService {
    @Autowired
    private TablesMapper tablesMapper;
    @Autowired
    private TablesRepository tablesRepository;

    @Override
    public TablesDTO getById(Long aLong) {
        return null;
    }

    @Override
    public TablesDTO save(TablesDTO tablesDTO) {
        return tablesMapper.toDto(tablesRepository.save(tablesMapper.toEntity(tablesDTO)));
    }

    @Override
    public TablesDTO update(TablesDTO tablesDTO) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
