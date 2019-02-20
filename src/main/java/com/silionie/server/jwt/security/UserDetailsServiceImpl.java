package com.silionie.server.jwt.security;

import com.silionie.server.domain.User;
import com.silionie.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String colonistId) throws UsernameNotFoundException {
        User user = userRepository.findByColonistId(colonistId);
        if (user == null) {
            throw new UsernameNotFoundException(colonistId);
        }
        return new org.springframework.security.core.userdetails.User(user.getColonistId(),
                user.getPassword(),
                emptyList());
    }
}
