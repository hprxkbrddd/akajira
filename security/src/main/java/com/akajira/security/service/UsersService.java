package com.akajira.security.service;

import com.akajira.security.entity.Users;
import com.akajira.security.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    @Transactional
    public Users register(Users user){
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
        return repository.save(user);
    }

    public String authenticate(Users user){
        Authentication auth =
                authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                    )
                );
        return auth.isAuthenticated() ? jwtService.generateToken(user.getUsername()) : "Failure";
    }
}
