package com.kipsang.tasksmanagement.services;

import com.kipsang.tasksmanagement.dtos.UserDto;
import com.kipsang.tasksmanagement.models.Users;
import com.kipsang.tasksmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder(12);
    public UserDto register(UserDto userDto) {
        Users user= new Users();
        user.setUsername(userDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        Users savedUser= userRepository.save(user);
        return  mapToUserDto(savedUser);
    }

    private UserDto mapToUserDto(Users savedUser) {
        return new UserDto(savedUser.getUsername(),savedUser.getPassword());
    }
}

