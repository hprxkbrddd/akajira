package com.akajira.security.model;

import com.akajira.security.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final Users user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // или логика из вашей сущности Users
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // или user.isAccountNonLocked()
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // или user.isCredentialsNonExpired()
    }

    @Override
    public boolean isEnabled() {
        return true; // или user.isEnabled()
    }
}
