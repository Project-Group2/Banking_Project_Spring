package com.lti.bankingProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.bankingProject.beans.Account;
import com.lti.bankingProject.beans.NetBankingAccount;
import com.lti.bankingProject.dao.CreateAccountDao;

@Service("createAccountService")
public class CreateAccountServiceImpl implements CreateAccountService{
	
	@Autowired
	private CreateAccountDao createAccountDao;
	
	Account accountService = null;
	NetBankingAccount netbankingAccountService= null;

	@Override
	public Account addAccount(Account account) {
		// TODO Auto-generated method stub
		accountService = createAccountDao.addAccount(account);
		return accountService;
	}
	

	@Override
	public Account registerNetbankingAccount(Long accountNumber, NetBankingAccount netbankingAccount) {
		// TODO Auto-generated method stub
		accountService = createAccountDao.registerNetbankingAccount(accountNumber, netbankingAccount);
		return accountService;
	}


	@Override
	public NetBankingAccount resestPassword(NetBankingAccount netbankingAccount) {
		// TODO Auto-generated method stub
		netbankingAccountService = createAccountDao.resestPassword(netbankingAccount);
		return netbankingAccountService;
	}
	
	

}
