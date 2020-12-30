package com.spring.service.impl;

import com.spring.DTO.UserDTO;
import com.spring.mapper.UserMapper;
import com.spring.repository.UserRepository;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO getById(Long id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такой заявки!");
        }
        return userMapper.toDto(userRepository.findById(id).get());
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(userDTO)));
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        if (userRepository.findById(userDTO.getId()).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такой заявки!");
        }
        return userMapper.toDto(userRepository.save(userMapper.toEntity(userDTO)));
    }

    @Override
    public void delete(Long id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такой заявки!");
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> findAll() {
        return userMapper.toDtos(userRepository.findAll());
    }
}
