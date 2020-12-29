//package com.spring.mapper;
//
//import com.spring.webcontent.DTO.UserDTO;
//import com.spring.webcontent.base.MapperService;
//import com.spring.webcontent.model.Role;
//import com.spring.webcontent.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class UserMapper implements MapperService<User, UserDTO> {
//    @Autowired
//    private RequestMapper requestMapper;
//    @Override
//    public User toEntity(UserDTO dto) {
//        User user = new User();
//        user.setId(dto.getId());
//        user.setName(dto.getName());
//        user.setPassword(dto.getPassword());
//        user.setEmail(dto.getEmail());
//        user.setRole(Role.valueOf(dto.getRole()));
//        return user;
//    }
//
//    @Override
//    public UserDTO toDto(User entity) {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(entity.getId());
//        userDTO.setName(entity.getName());
//        userDTO.setEmail(entity.getEmail());
//        userDTO.setPassword(entity.getPassword());
//        userDTO.setRole(entity.getRole().getNameRole());
//        userDTO.setRequestDTOList(requestMapper.toDtos(entity.getRequests()));
//        return userDTO;
//    }
//
//    @Override
//    public List<User> toEntities(List<UserDTO> dto) {
//        List<User> users = new ArrayList<>();
//        dto.forEach(userDTO -> users.add(toEntity(userDTO)));
//        return users;
//    }
//
//    @Override
//    public List<UserDTO> toDtos(List<User> entity) {
//        List<UserDTO> userDTOS = new ArrayList<>();
//        entity.forEach(user -> userDTOS.add(toDto(user)));
//        return userDTOS;
//    }
//}
