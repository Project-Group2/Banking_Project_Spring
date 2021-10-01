package com.lti.bankingProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.bankingProject.beans.Account;
import com.lti.bankingProject.dao.CreateAccountJpaDao;
import com.lti.bankingProject.dao.CreateNetBankingAccountJpaDao;

@Service
public class CreateAccountJpaService {
	
	@Autowired
	CreateAccountJpaDao createAccountJpaDao;
	@Autowired
	CreateNetBankingAccountJpaDao createNetBankingJpaDao;
	
	public List<Account> getAllAccounts() {
		return this.createAccountJpaDao.findAll();
	}
	
	public Account getSingleAccount(Long accountNumber) {
		return this.createAccountJpaDao.findById(accountNumber).get();
	}
	
	
	

}
