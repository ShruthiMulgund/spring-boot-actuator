package com.example.actuator.service;

import com.example.actuator.entity.User;
import com.example.actuator.entity.UserDto;
import com.example.actuator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDto(user.getId(), user.getName()))
                .collect(Collectors.toList());
    }

    public UserDto createUser(UserDto userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        User saved = userRepository.save(user);
        return new UserDto(saved.getId(), saved.getName());
    }
}
