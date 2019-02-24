package com.silionie.server.service;

import com.silionie.server.domain.User;
import com.silionie.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUser(String username){
        return userRepository.findByUsername(username);
    }
}
