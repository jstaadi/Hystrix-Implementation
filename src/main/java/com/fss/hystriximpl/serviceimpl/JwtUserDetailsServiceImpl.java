package com.fss.hystriximpl.serviceimpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Value("${jwt.tokenUsername}")
    private String tokenUsername;

    @Value("${jwt.tokenPassword}")
    private String tokenPassword;

    @Override
    public UserDetails loadUserByUsername(String username) {
        if (username.equals(tokenUsername)) {
            return new User(tokenUsername, tokenPassword, new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username " + username);
        }
    }

}
