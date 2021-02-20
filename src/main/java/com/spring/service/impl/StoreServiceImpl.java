package com.spring.service.impl;

import com.spring.DTO.StoreDTO;
import com.spring.model.Store;
import com.spring.repository.StoreRepository;
import com.spring.service.StoreService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;
    private final MapperFacade mapperFacade;

    @Override
    public StoreDTO getById(Long aLong) {
        return null;
    }

    @Override
    public StoreDTO save(StoreDTO storeDTO) {
        Store storeSave = storeRepository.save(mapperFacade.map(storeDTO, Store.class));
        return mapperFacade.map(storeSave, StoreDTO.class);
    }

    @Override
    public StoreDTO update(StoreDTO storeDTO) {
        if (storeRepository.findById(storeDTO.getId()).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого склада!");
        }
        Store storeSave = storeRepository.save(mapperFacade.map(storeDTO, Store.class));
        return mapperFacade.map(storeSave, StoreDTO.class);
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<StoreDTO> findAll() {
        return mapperFacade.mapAsList(storeRepository.findAll(), StoreDTO.class);
    }

    @Override
    public List<StoreDTO> findAllByUsersId(Long id) {
        return mapperFacade.mapAsList(storeRepository.findAllByUsersId(id), StoreDTO.class);
    }

    @Override
    public List<StoreDTO> findAllByIsProvide(Boolean bool) {
        return mapperFacade.mapAsList(storeRepository.findAllByIsProvide(bool), StoreDTO.class);
    }
}
