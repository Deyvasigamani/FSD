package com.cognizant.projectmanagement.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController   
@RequestMapping(path="/user")
@CrossOrigin
public class UserController {	
	
	
	@Autowired	
	private UserService userService;
	
	@RequestMapping(method =RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAllUser();
		
	}
	
	@RequestMapping(method =RequestMethod.POST)
	public @ResponseBody User createUser(@RequestBody User user) {
		return userService.createUser(user);
		
	}
	
	@RequestMapping(method =RequestMethod.PUT)
	public @ResponseBody User updateUser(@RequestBody User user,@PathVariable Long id) {
		return userService.updateUser(user,id);
		
	}
	

	@RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
	public @ResponseBody String deleteUser(@PathVariable Long id){
	     userService.deleteUser(id);
	     return "Success";
		
	}
}

