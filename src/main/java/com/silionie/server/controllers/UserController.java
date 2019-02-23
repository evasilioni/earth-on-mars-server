package com.silionie.server.controllers;

import com.silionie.server.domain.User;
import com.silionie.server.jwt.security.InvalidJwtAuthenticationException;
import com.silionie.server.jwt.security.JwtAuthenticationRequest;
import com.silionie.server.jwt.security.TokenProvider;
import com.silionie.server.jwt.security.service.CustomUserDetailsService;
import com.silionie.server.jwt.security.service.JwtAuthenticationResponse;
import com.silionie.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenProvider;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    @RequestMapping(
            value = "/signin",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    ResponseEntity<?> signIn(@RequestBody JwtAuthenticationRequest authenticationRequest) {
        User persistedUser = userService.findUser(authenticationRequest.getUsername());
        if (persistedUser != null) {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
                // Reload password post-security so we can generate the token
                final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
                final String token = jwtTokenProvider.createToken(userDetails.getUsername(), new ArrayList<>());

                // Return the token
                return ResponseEntity.ok(new JwtAuthenticationResponse(token));
            } catch (InvalidJwtAuthenticationException ex ) {
                return ResponseEntity.status(403).body(ex.getMessage());
            }
        }
        return ResponseEntity.notFound().build();
    }

}
