package com.spring.mapper;

import com.spring.DTO.StoreDTO;
import com.spring.DTO.UserDTO;
import com.spring.base.MapperService;
import com.spring.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class UserMapper implements MapperService<User, UserDTO> {
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private PassportMapper passportMapper;
//    @Autowired
//    private StoreMapper storeMapper;
    @Override
    public User toEntity(UserDTO dto) {
        log.info("UserDTO {}", dto);
        User user = new User();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setSecondName(dto.getSecondName());
        if (dto.getAddress() != null) {
            user.setAddress(addressMapper.toEntity(dto.getAddress()));
        }
        user.setNumberINN(dto.getNumberINN());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setDateBirth(dto.getDateBirth());
        if (dto.getGender() != null) {
            user.setGender(Gender.valueOf(dto.getGender()));
        }
        if (dto.getPosition() != null) {
            user.setPosition(positionMapper.toEntity(dto.getPosition()));
        }
        user.setSubdivision(new Subdivision(dto.getSubdivisionId()));
//        if (dto.getStore() != null) {
//            user.setStores(storeMapper.mapAsList(dto.getStore(), Store.class));
//        }
        if (dto.getPassport() != null) {
            user.setPassport(passportMapper.toEntity(dto.getPassport()));
        }
        user.setVacationStart(dto.getVacationStart());
        user.setVacationFinal(dto.getVacationFinal());
        user.setPassword(dto.getPassword());
        if (dto.getRole() != null) {
            user.setRole(Role.valueOf(dto.getRole()));
        }
        user.setNameFirm(dto.getNameFirm());
        log.info("User {}", user);
        return user;
    }

    @Override
    public UserDTO toDto(User entity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(entity.getId());
        userDTO.setFirstName(entity.getFirstName());
        userDTO.setLastName(entity.getLastName());
        userDTO.setSecondName(entity.getSecondName());
        if (entity.getAddress() != null) {
            userDTO.setAddress(addressMapper.toDto(entity.getAddress()));
        }
        userDTO.setNumberINN(entity.getNumberINN());
        userDTO.setEmail(entity.getEmail());
        userDTO.setPhone(entity.getPhone());
        userDTO.setDateBirth(entity.getDateBirth());
        if (entity.getGender() != null) {
            userDTO.setGender(entity.getGender().getNameGender());
        }
        if (entity.getPosition() != null) {
            userDTO.setPosition(positionMapper.toDto(entity.getPosition()));
        }
        userDTO.setSubdivisionId(entity.getSubdivision().getId());
//        if (entity.getStores() != null) {
//            userDTO.setStore(storeMapper.mapAsList(entity.getStores(), StoreDTO.class));
//        }
        if (entity.getPassport() != null) {
            userDTO.setPassport(passportMapper.toDto(entity.getPassport()));
        }
        userDTO.setVacationStart(entity.getVacationStart());
        userDTO.setVacationFinal(entity.getVacationFinal());
        userDTO.setPassword(entity.getPassword());
        if (entity.getRole() != null) {
            userDTO.setRole(entity.getRole().getNameRole());
        }
        userDTO.setNameFirm(entity.getNameFirm());
        return userDTO;
    }

    public UserDTO toDtoNotUserInStore(User entity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(entity.getId());
        userDTO.setFirstName(entity.getFirstName());
        userDTO.setLastName(entity.getLastName());
        userDTO.setSecondName(entity.getSecondName());
        if (entity.getAddress() != null) {
            userDTO.setAddress(addressMapper.toDto(entity.getAddress()));
        }
        userDTO.setNumberINN(entity.getNumberINN());
        userDTO.setEmail(entity.getEmail());
        userDTO.setPhone(entity.getPhone());
        userDTO.setDateBirth(entity.getDateBirth());
        if (entity.getGender() != null) {
            userDTO.setGender(entity.getGender().getNameGender());
        }
        if (entity.getPosition() != null) {
            userDTO.setPosition(positionMapper.toDto(entity.getPosition()));
        }
        userDTO.setSubdivisionId(entity.getSubdivision().getId());
        if (entity.getPassport() != null) {
            userDTO.setPassport(passportMapper.toDto(entity.getPassport()));
        }
//        if (entity.getStores() != null) {
//            List<Store> stores = new ArrayList<>();
//            entity.getStores().forEach(store -> {
//                store.setUsers(null);
//                stores.add(store);
//            });
//            userDTO.setStore(storeMapper.mapAsList(stores, StoreDTO.class));
//        }
        userDTO.setVacationStart(entity.getVacationStart());
        userDTO.setVacationFinal(entity.getVacationFinal());
        userDTO.setPassword(entity.getPassword());
        if (entity.getRole() != null) {
            userDTO.setRole(entity.getRole().getNameRole());
        }
        userDTO.setNameFirm(entity.getNameFirm());
        return userDTO;
    }

    @Override
    public List<User> toEntities(List<UserDTO> dto) {
        List<User> users = new ArrayList<>();
        dto.forEach(userDTO -> users.add(toEntity(userDTO)));
        return users;
    }

    @Override
    public List<UserDTO> toDtos(List<User> entity) {
        List<UserDTO> userDTOS = new ArrayList<>();
        entity.forEach(user -> userDTOS.add(toDto(user)));
        return userDTOS;
    }

    public List<UserDTO> toDtoNotUserInStore(List<User> entity) {
        List<UserDTO> userDTOS = new ArrayList<>();
        entity.forEach(user -> userDTOS.add(toDtoNotUserInStore(user)));
        return userDTOS;
    }
}
