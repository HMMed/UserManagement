package com.example.demo.service;

import com.example.demo.model.Role;

public interface RoleService {
	
	public Role save(Role role);

	public Role findByName(String name);

}
