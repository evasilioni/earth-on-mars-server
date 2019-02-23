package com.silionie.server.controllers;

import com.silionie.server.domain.User;
import com.silionie.server.jwt.security.JwtAuthenticationRequest;
import com.silionie.server.jwt.security.JwtAuthenticationResponse;
import com.silionie.server.jwt.security.TokenProvider;
import com.silionie.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenProvider;

    @RequestMapping(
            value = "/sign-in",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    ResponseEntity<?> signIn(@RequestBody JwtAuthenticationRequest authenticationRequest) {
        String token = authenticationRequest.getHeader(tokenHeader).substring(7);
        String username = jwtTokenProvider.getUserNameFromToken(token);
        User persistedUser = userService.findUser(JwtAuthenticationRequest.map(authenticationRequest));
        if (persistedUser != null) {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(persistedUser.getUsername(), persistedUser.getPassword()));
                String token = jwtTokenProvider.createToken(persistedUser.getUsername(), persistedUser.getRoles());

                JwtAuthenticationResponse.map(persistedUser, token);
                return ResponseEntity.ok(JwtAuthenticationResponse.map(persistedUser, token));
            } catch (AuthenticationException ex) {
                throw new BadCredentialsException("Invalid username/password supplied");
            }
        }
        return ResponseEntity.notFound().build();
    }

}
