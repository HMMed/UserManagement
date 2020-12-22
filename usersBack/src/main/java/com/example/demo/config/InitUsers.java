package com.example.demo.config;
import java.util.Arrays;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(2) //pour qu'il sera exécuté après initRoles
@Component //pour qu'elle sera un bean sera connu par 
public class InitUsers implements ApplicationRunner{

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		Role roleUser = roleRepository.findRoleByName("ROLE_USER");
		Role roleAdmin = roleRepository.findRoleByName("ROLE_ADMIN");
		
		User user = new User("user", "user");
		user.setRoles(Arrays.asList(roleUser));// conversion d'objet vers une liste
		
		User admin = new User("admin", "admin");
		admin.setRoles(Arrays.asList(roleUser, roleAdmin));
		
		
		userService.ajout(user);
		userService.ajout(admin);//
		//userRepository.save(admin);

	}
	

}
