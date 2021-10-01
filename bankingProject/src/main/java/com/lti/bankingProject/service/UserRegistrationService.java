package com.lti.bankingProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.bankingProject.beans.UserRegistration;
import com.lti.bankingProject.dao.UserRegistrationDao;



@Service
public class UserRegistrationService {
	
	@Autowired
	UserRegistrationDao UserDao;
	
	
	
	  public List<UserRegistration> getAll() {
	         return this.UserDao.findAll();
     }
	 
	    

		public UserRegistration adduser(UserRegistration user) {
			
			return this.UserDao.save(user);
		}

}
