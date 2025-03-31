package com.akajira.security.controller;

import com.akajira.security.entity.Users;
import com.akajira.security.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/akajira/security")
@RequiredArgsConstructor
public class SecurityController {

    private final UsersService service;

    @PostMapping("auth/authenticate")
    public String authenticate(@RequestBody Users user){
        return service.authenticate(user);
    }

    @PostMapping("auth/register")
    public Users register(@RequestBody Users user){
        return service.register(user);
    }


}
