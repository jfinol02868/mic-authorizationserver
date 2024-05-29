package com.tecomerce.mic.authorizationserver.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.util.Collection;

public class UsernamePasswordAuthenticationTokenImpl extends UsernamePasswordAuthenticationToken {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
    private String test;

    public UsernamePasswordAuthenticationTokenImpl(Object principal, Object credentials, String test) {
        super(principal, credentials);
        this.test = test;
        super.setAuthenticated(false);
    }

    public UsernamePasswordAuthenticationTokenImpl(Object principal, Object credentials, String test, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        this.test = test;
    }

    public String getTest() {
        return this.test;
    }
}
