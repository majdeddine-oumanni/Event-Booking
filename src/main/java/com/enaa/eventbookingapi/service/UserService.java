package com.enaa.eventbookingapi.service;


import com.enaa.eventbookingapi.DTO.UserDto;
import com.enaa.eventbookingapi.Mapper.UserMapper;
import com.enaa.eventbookingapi.Model.User;
import com.enaa.eventbookingapi.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepository;
    private final UserMapper userMapper;
    public UserService(UserRepo userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto registerUser(UserDto dto) {
        User user = userMapper.toEntity(dto);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    public UserDto findByUsername(String username) {
        User user = userRepository.findByName(username);
        return userMapper.toDTO(user);
    }

    public List<UserDto> findAll() {
        List<UserDto> userDtoList = userMapper.toDTOs(userRepository.findAll());
        return userDtoList;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public UserDto update(Long id, UserDto dto) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not fondi: " + id));

        foundUser.setName(dto.getName());
        foundUser.setEmail(dto.getEmail());

        User savedUser = userRepository.save(foundUser);
        return userMapper.toDTO(savedUser);
    }

}