package com.akajira.security.controller;

import com.akajira.security.entity.Users;
import com.akajira.security.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("akajira/api/auth/")
@RequiredArgsConstructor
public class SecurityController {

    private final UsersService service;

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody Users user){
        return service.authenticate(user);
    }

    @PostMapping("/registrate")
    public Users register(@RequestBody Users user){
        return service.register(user);
    }
}
