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
        User user2 = users.findByUsername("user2");

        esilioni.setPassword(passwordEncoder.encode(esilioni.getPassword()));
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        user2.setPassword(passwordEncoder.encode(user2.getPassword()));

        users.save(esilioni);
        users.save(admin);
        users.save(user2);

    }
}