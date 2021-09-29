package com.lti.bankingProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.bankingProject.beans.Account;
import com.lti.bankingProject.beans.NetBankingAccount;

public interface CreateAccountJpaDao extends JpaRepository<Account, Long>{
	
}
