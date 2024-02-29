package com.example.services;

import com.example.dtos.UserDto;
import com.example.entities.User;
import com.example.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    public UserDto saveUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        return this.modelMapper.map(this.userRepository.save(user), UserDto.class);
    }

}
