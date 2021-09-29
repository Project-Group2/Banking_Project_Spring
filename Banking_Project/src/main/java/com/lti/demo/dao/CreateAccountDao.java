package com.lti.demo.dao;

import com.lti.demo.beans.Account;
import com.lti.demo.beans.NetBankingAccount;

public interface CreateAccountDao {
	
	public abstract Account accountWithoutNetbanking(Account account);
	public abstract Account accountWithNetbanking(Account account);
	public abstract Account registerNetbankingAccount(Long accountNumber, NetBankingAccount netbankingAccount);
	
}
