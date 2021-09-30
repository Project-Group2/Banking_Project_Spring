package com.lti.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.lti.demo.beans.User_Registration;
import com.lti.demo.service.UserRegisterService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/userregister")
public class userRegisterController {
	
	
	@Autowired
	UserRegisterService userservice;
	
	@RequestMapping("/all")
	@GetMapping
	public List<User_Registration> getAllUsers(){
		return userservice.getAll();
	}
	
	@RequestMapping(value = "/adduser")
	@PostMapping
    public User_Registration addNewuser(@RequestBody User_Registration user) {
        return this.userservice.adduser(user);
    }
	

}
