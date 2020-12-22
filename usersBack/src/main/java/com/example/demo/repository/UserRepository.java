package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;

	public interface UserRepository extends JpaRepository<User, Integer>{

		public User findUserByUsername(String username);
		
		//DSL domain Specefic Language
		//public List<User> findAllByIdGreaterThan();
		
		//HQL
		@Query("SELECT u FROM User u WHERE u.username =:username")
		public User getUserWithUsername (@Param("username") String username);
}
