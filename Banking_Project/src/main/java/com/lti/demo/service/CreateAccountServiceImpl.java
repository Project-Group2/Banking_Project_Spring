package com.lti.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.demo.beans.Account;
import com.lti.demo.beans.NetBankingAccount;
import com.lti.demo.dao.CreateAccountDao;

@Service("createAccountService")
public class CreateAccountServiceImpl implements CreateAccountService{
	
	@Autowired
	private CreateAccountDao createAccountDao;
	
	Account accountService = null;
	NetBankingAccount netbankingAccountService= null;

	@Override
	public Account accountWithoutNetbanking(Account account) {
		// TODO Auto-generated method stub
		accountService = createAccountDao.accountWithoutNetbanking(account);
		return accountService;
	}

	@Override
	public Account accountWithNetbanking(Account account) {
		// TODO Auto-generated method stub
		accountService = createAccountDao.accountWithNetbanking(account);
		return accountService;
	}

	@Override
	public Account registerNetbankingAccount(Long accountNumber, NetBankingAccount netbankingAccount) {
		// TODO Auto-generated method stub
		accountService = createAccountDao.registerNetbankingAccount(accountNumber, netbankingAccount);
		return accountService;
	}
	

}
