package com.lti.bankingProject.service;

import java.util.List;

import com.lti.bankingProject.beans.Account;
import com.lti.bankingProject.beans.NetBankingAccount;
import com.lti.bankingProject.beans.Transaction;
import com.lti.bankingProject.beans.UserRegistration;

public interface CreateAccountService {
	
	public abstract Account addAccount(Long userRegistrationNumber, Account account);
	public abstract Account registerNetbankingAccount(Long accountNumber, NetBankingAccount netbankingAccount);
	public abstract NetBankingAccount resestPassword(NetBankingAccount netbankingAccount);
	public abstract Account getAccountbyUserId(Long netbankingUserId);
	public abstract List<Transaction> getDateWiseTransactionsFor(Long accountNumber, String fromDate, String toDate);
	public abstract List<Transaction> get5TransactionsFor(Long accountNumber);
	public abstract List<UserRegistration> getPendingRegisters();
	public abstract UserRegistration getUserProfileById(Long userId);
	public abstract UserRegistration rejectUserRegistration(Long serviceId);
	public abstract UserRegistration updateUser(UserRegistration userUpdate);
	public abstract NetBankingAccount loginUser(Long userId);
	public abstract Account getAccount(Long accountNumber);
	public abstract UserRegistration createUser(UserRegistration user);
	


}
