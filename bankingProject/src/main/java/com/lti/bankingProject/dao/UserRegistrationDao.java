package com.lti.bankingProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.lti.bankingProject.beans.UserRegistration;

public interface UserRegistrationDao extends JpaRepository<UserRegistration, Long> {

}
