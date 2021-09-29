package com.lti.demo.service;

import com.lti.demo.beans.Account;
import com.lti.demo.beans.NetBankingAccount;

public interface CreateAccountService {
	
	public abstract Account accountWithoutNetbanking(Account account);
	public abstract Account accountWithNetbanking(Account account);
	public abstract Account registerNetbankingAccount(Long accountNumber, NetBankingAccount netbankingAccount);

}
