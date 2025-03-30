package com.akajira.security.service;

import com.akajira.security.model.UserDetailsImpl;
import com.akajira.security.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersDetailsService implements UserDetailsService {

    private final UsersRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDetailsImpl(repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("User with name '%s' is not found", username))));
    }
}
