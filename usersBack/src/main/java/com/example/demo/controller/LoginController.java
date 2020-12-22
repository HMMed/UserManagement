package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AuthenticationResponse;
import com.example.demo.model.User;
import com.example.demo.security.MyUserDetailsService;
import com.example.demo.util.JwtUtil;

@RestController
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager; //injection de dépendance
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthentificationToken(@RequestBody User user) throws Exception {
	
	try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		
	}catch (BadCredentialsException e) {
		throw new Exception("Incorrect username or password", e);
	}
	
	
	final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
	//Create an object UserDetails
	final String token = jwtTokenUtil.generateToken(userDetails); // Create a token using the service JwtUtil
	
	return ResponseEntity.ok(new AuthenticationResponse(token, user.getUsername(), userDetails.getAuthorities()));
	}

}

