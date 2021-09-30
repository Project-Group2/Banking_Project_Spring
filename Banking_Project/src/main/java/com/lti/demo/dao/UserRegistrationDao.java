package com.lti.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.lti.demo.beans.User_Registration;

public interface UserRegistrationDao extends JpaRepository<User_Registration, Long> {

}
