//package com.spring.service.impl;
//
//import com.spring.webcontent.DTO.AddressDTO;
//import com.spring.webcontent.mapper.AddressMapper;
//import com.spring.webcontent.repository.AddressRepository;
//import com.spring.webcontent.service.AddressService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AddressServiceImpl implements AddressService {
//    @Autowired
//    private AddressRepository addressRepository;
//    @Autowired
//    private AddressMapper addressMapper;
//
//    @Override
//    public AddressDTO getById(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public AddressDTO save(AddressDTO addressDTO) {
//        return addressMapper.toDto(addressRepository.save(addressMapper.toEntity(addressDTO)));
//    }
//
//    @Override
//    public AddressDTO update(AddressDTO addressDTO) {
//        return null;
//    }
//
//    @Override
//    public void delete(Long aLong) {
//
//    }
//}
