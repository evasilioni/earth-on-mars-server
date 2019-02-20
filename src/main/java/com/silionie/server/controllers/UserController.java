package com.silionie.server.controllers;

import com.silionie.server.domain.User;
import com.silionie.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(
            value = "/sign-in",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    ResponseEntity<User> signIn(@RequestBody User user) {
        User persistedUser = userService.findUser(user);
        if(persistedUser != null){
            return ResponseEntity.ok(persistedUser);
        }
        return ResponseEntity.notFound().build();
    }
}
