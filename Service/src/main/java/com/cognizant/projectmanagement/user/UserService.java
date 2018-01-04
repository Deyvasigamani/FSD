package com.cognizant.projectmanagement.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	
	@Autowired 
	private UserRepository userRepository;
	
	
	public List<User> getAllUser() {
		
		List<User> users = new ArrayList();		 
		userRepository.findAll().forEach(users::add);
		return users;
		
	}
	
    public User getUser(Long id) {		
		
	return userRepository.findOne(id);		 
		
	}


	public User createUser(User user) {
		
		return userRepository.save(user);
	}


	public User updateUser(User user, Long id) {
		
		return userRepository.save(user);
	}


	public void deleteUser(Long id) {
		userRepository.delete(id);
		
	}

}
