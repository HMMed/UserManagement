package com.example.demo.config;
import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;

//import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class InitRoles implements ApplicationRunner{
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Role roleUser = new Role("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
	}
}
