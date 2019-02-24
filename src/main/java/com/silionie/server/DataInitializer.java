package com.silionie.server;

import com.silionie.server.domain.User;
import com.silionie.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    UserRepository users;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        User esilioni = users.findByUsername("esilioni");
        User admin = users.findByUsername("admin");

        esilioni.setPassword(passwordEncoder.encode(esilioni.getPassword()));
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));

        users.save(esilioni);
        users.save(admin);

        for(int i=2; i<=7; i++){
            User user = users.findByUsername("user" +i);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            users.save(user);
        }

    }
}