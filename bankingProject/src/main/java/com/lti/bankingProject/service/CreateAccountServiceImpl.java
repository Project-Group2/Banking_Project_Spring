package com.lti.bankingProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.bankingProject.beans.Account;
import com.lti.bankingProject.beans.NetBankingAccount;
import com.lti.bankingProject.beans.Transaction;
import com.lti.bankingProject.beans.UserRegistration;
import com.lti.bankingProject.dao.CreateAccountDao;

@Service("createAccountService")
public class CreateAccountServiceImpl implements CreateAccountService{
	
	@Autowired
	private CreateAccountDao createAccountDao;
	
	Account accountService = null;
	NetBankingAccount netbankingAccountService= null;

	@Override
	public Account addAccount(Long userRegistrationNumber, Account account) {
		// TODO Auto-generated method stub
		accountService = createAccountDao.addAccount(userRegistrationNumber, account);
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


	@Override
	public Account getAccountbyUserId(Long netbankingUserId) {
		// TODO Auto-generated method stub
		accountService = createAccountDao.getAccountbyUserId(netbankingUserId);
		return accountService;
	}


	
	@Override
	public List<Transaction> get5TransactionsFor(Long accountNumber) {
		// TODO Auto-generated method stub
		List accountService = createAccountDao.get5TransactionsFor(accountNumber);
		return accountService;
	}


	@Override
	public List<UserRegistration> getPendingRegisters() {
		// TODO Auto-generated method stub
		List transactionService = createAccountDao.getPendingRegisters();
		return transactionService;
	}


	@Override
	public UserRegistration getUserProfileById(Long userId) {
		// TODO Auto-generated method stub
		UserRegistration userProfile = createAccountDao.getUserProfileById(userId);
		return userProfile;
	}


	@Override
	public UserRegistration rejectUserRegistration(Long serviceId) {
		// TODO Auto-generated method stub
		UserRegistration rejectUser = createAccountDao.rejectUserRegistration(serviceId);
		return rejectUser;
	}


	@Override
	public UserRegistration updateUser(UserRegistration userUpdate) {
		// TODO Auto-generated method stub
		UserRegistration tempUser = createAccountDao.updateUser(userUpdate);
		return tempUser;
	}


	@Override
	public List<Transaction> getDateWiseTransactionsFor(Long accountNumber, String fromDate, String toDate) {
		// TODO Auto-generated method stub
		List<Transaction> transactionDateWise = createAccountDao.getDateWiseTransactionsFor(accountNumber, fromDate, toDate);
		return transactionDateWise;
	}


	@Override
	public NetBankingAccount loginUser(Long userId) {
		// TODO Auto-generated method stub
		NetBankingAccount result = createAccountDao.loginUser(userId);
		System.out.println(result);
		return result;
	}


	@Override
	public Account getAccount(Long accountNumber) {
		// TODO Auto-generated method stub
		accountService = createAccountDao.getAccount(accountNumber);
		return accountService;
	}
	
	

}
