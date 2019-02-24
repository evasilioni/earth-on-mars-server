package com.silionie.server.jwt.security.service;

import com.silionie.server.domain.User;
import com.silionie.server.jwt.security.JwtUser;
import com.silionie.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService")
public class JwtUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return new JwtUser.JwtUserBuilder(user)
                    .setFirstname(user.getFirstName())
                    .setLastname(user.getFirstName())
                    .build();
        }
    }
}
