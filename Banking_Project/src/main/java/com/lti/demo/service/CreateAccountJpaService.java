package com.lti.demo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.demo.beans.Account;
import com.lti.demo.beans.NetBankingAccount;
import com.lti.demo.dao.CreateAccountJpaDao;
import com.lti.demo.dao.CreateNetBankingAccountJpaDao;

@Service
public class CreateAccountJpaService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	CreateAccountJpaDao createAccountJpaDao;
	@Autowired
	CreateNetBankingAccountJpaDao createNetBankingJpaDao;
	
	public Account createNewAccount(Account account) {
		return this.createAccountJpaDao.save(account);
	}
	
//	@Transactional
//	public Account newAccountWithNetbanking(NetBankingAccount netbankingAccount, Account account) {
//		account.setNetbankingAccount(netbankingAccount);
//		this.createNetBankingJpaDao.save(netbankingAccount);
//		this.createAccountJpaDao.save(account);
//		return account;
//		
//	}
	
	
	@Transactional
	public Account netBankingRegister(NetBankingAccount netbankingAccount, Long accountNumber) {
		Account tempAccount = em.find(Account.class, (long)accountNumber);
		tempAccount.setNetbankingAccount(netbankingAccount);
		tempAccount.setIfNetBanking("YES");
		em.persist(netbankingAccount);
		em.merge(tempAccount);
		return tempAccount;
	}

}
