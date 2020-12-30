package com.spring.service;


import com.spring.DTO.UserDTO;
import com.spring.base.CRUDService;

import java.util.List;

public interface UserService extends CRUDService<UserDTO, Long> {
    List<UserDTO> findAll();
}
