package com.spring.service.impl;

import com.spring.DTO.AddressDTO;
import com.spring.model.Address;
import com.spring.repository.AddressRepository;
import com.spring.service.AddressService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final MapperFacade mapperFacade;

    @Override
    public AddressDTO getById(Long aLong) {
        return null;
    }

    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        Address address = addressRepository.save(mapperFacade.map(addressDTO, Address.class));
        return mapperFacade.map(address, AddressDTO.class);
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<AddressDTO> findAll() {
        return null;
    }
}
