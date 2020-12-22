package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Role;
import com.example.demo.model.User;

@Repository// indiquer à spring qui c'est une couche repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	public Role findRoleByName(String name);

}
