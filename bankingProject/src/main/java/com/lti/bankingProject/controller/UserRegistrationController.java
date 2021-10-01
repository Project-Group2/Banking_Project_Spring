package com.lti.bankingProject.controller;

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


import com.lti.bankingProject.beans.UserRegistration;
import com.lti.bankingProject.service.UserRegistrationService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/userregister")
public class UserRegistrationController {
	
	
	@Autowired
	UserRegistrationService userservice;
	
	@RequestMapping("/all")
	@GetMapping
	public List<UserRegistration> getAllUsers(){
		return userservice.getAll();
	}
	
	@RequestMapping(value = "/adduser")
	@PostMapping
    public UserRegistration addNewuser(@RequestBody UserRegistration user) {
        return this.userservice.adduser(user);
    }
	

}
