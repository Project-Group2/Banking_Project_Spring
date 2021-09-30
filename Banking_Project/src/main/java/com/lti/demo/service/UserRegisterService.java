package com.lti.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.demo.beans.User_Registration;
import com.lti.demo.dao.UserRegistrationDao;

@Service
public class UserRegisterService {
	
	@Autowired
	UserRegistrationDao UserDao;
	
	
	
	  public List<User_Registration> getAll() {
	         return this.UserDao.findAll();
     }
	 
	    

		public User_Registration adduser(User_Registration user) {
			
			return this.UserDao.save(user);
		}

}
