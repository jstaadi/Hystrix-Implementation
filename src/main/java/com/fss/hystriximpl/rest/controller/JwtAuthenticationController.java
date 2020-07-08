package com.fss.hystriximpl.rest.controller;

import com.fss.hystriximpl.dto.JwtRequestDto;
import com.fss.hystriximpl.serviceimpl.JwtUserDetailsServiceImpl;
import com.fss.hystriximpl.utils.JwtUtil;
import com.fss.hystriximpl.utils.ResponseBuilder;
import com.fss.hystriximpl.utils.ResponseData;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@CrossOrigin
@Api(value = "JWT Token requested API")
public class JwtAuthenticationController extends ResponseBuilder {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsServiceImpl userDetailsService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<ResponseData<Object>> createAuthenticationToken(@RequestBody JwtRequestDto authenticationRequest) {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        return invokeService(() -> jwtTokenUtil.generateToken(userDetails));

    }

    private void authenticate(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            log.error("Account disabled {} ", e.getMessage(), e);
            throw e;
        } catch (BadCredentialsException e) {
            log.error("Bad Credentials {} ", e.getMessage(), e);
            throw e;
        }
    }

}
