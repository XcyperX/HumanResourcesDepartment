package com.spring.mapper;

import com.spring.DTO.AddressDTO;
import com.spring.base.MapperService;
import com.spring.model.Address;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressMapper implements MapperService<Address, AddressDTO> {
    @Override
    public Address toEntity(AddressDTO dto) {
        Address address = new Address();
        address.setCity(dto.getCity());
        address.setHouse(dto.getHouse());
        address.setFlat(dto.getFlat());
        address.setStreet(dto.getStreet());
        return address;
    }

    @Override
    public AddressDTO toDto(Address entity) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(entity.getId());
        addressDTO.setCity(entity.getCity());
        addressDTO.setStreet(entity.getStreet());
        addressDTO.setHouse(entity.getHouse());
        addressDTO.setFlat(entity.getFlat());
        return addressDTO;
    }

    @Override
    public List<Address> toEntities(List<AddressDTO> dto) {
        List<Address> addresses = new ArrayList<>();
        dto.forEach(addressDTO -> addresses.add(toEntity(addressDTO)));
        return addresses;
    }

    @Override
    public List<AddressDTO> toDtos(List<Address> entity) {
        List<AddressDTO> addressDTOS = new ArrayList<>();
        entity.forEach(address -> addressDTOS.add(toDto(address)));
        return addressDTOS;
    }
}
