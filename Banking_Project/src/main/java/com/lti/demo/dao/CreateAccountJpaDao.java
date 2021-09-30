package com.lti.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.demo.beans.Account;


public interface CreateAccountJpaDao extends JpaRepository<Account, Long>{
	
}
