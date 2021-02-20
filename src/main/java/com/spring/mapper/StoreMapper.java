package com.spring.mapper;

import com.spring.DTO.OrderHistoryDTO;
import com.spring.DTO.StoreDTO;
import com.spring.base.MapperService;
import com.spring.model.*;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
//public class StoreMapper extends ConfigurableMapper {
//    protected void configure(MapperFactory factory) {
//        factory.classMap(Store.class, StoreDTO.class)
//                .byDefault()
//                .register();
//    }
//}
//public class StoreMapper implements MapperService<Store, StoreDTO> {
//    @Autowired
//    private ProductMapper productMapper;
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    public Store toEntity(StoreDTO dto) {
//        Store store = new Store();
//        store.setId(dto.getId());
//        store.setName(dto.getName());
//        if (dto.getSuppliesId() != null) {
//            store.setSupplies(new Supplies(dto.getSuppliesId()));
//        }
////        if (dto.getUsers() != null) {
////            store.setUsers(userMapper.toEntities(dto.getUsers()));
////        }
//        store.setIsProvide(dto.getIsProvide());
//        return store;
//    }
//
//    @Override
//    public StoreDTO toDto(Store entity) {
//        StoreDTO storeDTO = new StoreDTO();
//        storeDTO.setId(entity.getId());
//        storeDTO.setName(entity.getName());
//        if (entity.getSupplies() != null) {
//            storeDTO.setSuppliesId(entity.getSupplies().getId());
//        }
////        if (entity.getUsers() != null) {
////            storeDTO.setUsers(userMapper.toDtos(entity.getUsers()));
////        }
//        storeDTO.setIsProvide(entity.getIsProvide());
//        return storeDTO;
//    }
//
//
//    @Override
//    public List<Store> toEntities(List<StoreDTO> dto) {
//        List<Store> stores = new ArrayList<>();
//        dto.forEach(storeDTO -> stores.add(toEntity(storeDTO)));
//        return stores;
//    }
//
//    @Override
//    public List<StoreDTO> toDtos(List<Store> entity) {
//        List<StoreDTO> storeDTOS = new ArrayList<>();
//        entity.forEach(store -> storeDTOS.add(toDto(store)));
//        return storeDTOS;
//    }
//}
