package com.tecomerce.mic.authorizationserver.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Objects;

public class UsernamePasswordAuthenticationFilterImpl extends UsernamePasswordAuthenticationFilter {

    public static final String SPRING_SECURITY_FORM_TEST_KEY = "test";

    public UsernamePasswordAuthenticationFilterImpl(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        UsernamePasswordAuthenticationToken authRequest = getAuthRequest(request);
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    private UsernamePasswordAuthenticationToken getAuthRequest(HttpServletRequest request) {
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        String test = obtainTest(request);

        if (Objects.isNull(username)) username = "";
        if (Objects.isNull(password)) password = "";
        if (Objects.isNull(test)) test = "";


        return new UsernamePasswordAuthenticationToken(username, password);
        //return new UsernamePasswordAuthenticationToken(username, password, test);

    }

    private String obtainTest(HttpServletRequest request) {
        return request.getParameter(SPRING_SECURITY_FORM_TEST_KEY);
    }
}
