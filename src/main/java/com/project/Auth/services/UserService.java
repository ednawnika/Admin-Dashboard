package com.project.Auth.services;

import java.util.List;
import java.util.*;

import javax.persistence.*;
import com.project.Auth.models.User;
import com.project.Auth.models.Role;
import com.project.Auth.repositories.RoleRepository;
import com.project.Auth.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserService(UserRepository userRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	// 1
	public void saveWithUserRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_USER"));
		userRepository.save(user);
	}

	// 2 
	public void saveUserWithAdminRole(User user) {
		
		user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
		userRepository.save(user);
	}

	// 3
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);

	}


	public List<User> findAll() {
		return (List<User>) userRepository.findAll();

	}
	
	public List<Role> findAlls() {
		return (List<Role>) roleRepository.findAll();

	}

	public void deleteUser(Long index) {
		System.out.println("hello" + index);
			userRepository.delete(index);
		}

		public void makeAdmin(User user) {
		ArrayList<Role> useradmin = new ArrayList<Role>();
		useradmin.add(roleRepository.findByname("ROLE_USER"));
		useradmin.add(roleRepository.findByname("ROLE_ADMIN"));
		user.setRoles(useradmin);
		user.setLevel("Admin");
		userRepository.save(user);
	}
	
	public User get(Long id) {
		return userRepository.findById(id);
	}


	}


