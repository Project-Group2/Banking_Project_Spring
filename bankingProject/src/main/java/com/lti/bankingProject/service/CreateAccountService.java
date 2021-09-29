package com.lti.bankingProject.service;

import com.lti.bankingProject.beans.Account;
import com.lti.bankingProject.beans.NetBankingAccount;

public interface CreateAccountService {
	
	public abstract Account accountWithoutNetbanking(Account account);
	public abstract Account accountWithNetbanking(Account account);
	public abstract Account registerNetbankingAccount(Long accountNumber, NetBankingAccount netbankingAccount);

}
