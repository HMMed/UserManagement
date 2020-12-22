package com.example.demo.model;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class AuthenticationResponse implements Serializable {

    private final String token;
    
    private final String username;
    
    private final Collection<? extends GrantedAuthority> authorities;

	public String getToken() {
		return token;
	}

	public String getUsername() {
		return username;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public AuthenticationResponse(String token, String username, Collection<? extends GrantedAuthority> authorities) {
		this.token = token;
		this.username = username;
		this.authorities = authorities;
	}
	
    
}
