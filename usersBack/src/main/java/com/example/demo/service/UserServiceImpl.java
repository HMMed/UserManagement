package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service // indiquer à spring que c'est une couche service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public List<User> userList() {
		return userRepository.findAll();
	}

	@Override
	public User ajout(User user) {
		String password = user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(password));//Encrypt the password
		return userRepository.save(user);
	}

	@Override
	public User edit(User user) {
		User newUser = this.getUserById(user.getId());
		if(newUser !=null) {
			BeanUtils.copyProperties(user, newUser, "password");
			userRepository.save(newUser);
		}
		return newUser;
	}

	@Override
	public void delete(Integer userId) {
		userRepository.deleteById(userId);
		
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}

	@Override
	public User getUserById(Integer Id) {
		Optional<User> user = userRepository.findById(Id);
		return user.isPresent()? user.get(): null;
	}
	

}
