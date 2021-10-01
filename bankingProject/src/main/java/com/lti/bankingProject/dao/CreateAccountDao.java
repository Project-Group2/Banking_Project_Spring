package com.lti.bankingProject.dao;

import com.lti.bankingProject.beans.Account;
import com.lti.bankingProject.beans.NetBankingAccount;

public interface CreateAccountDao {
	
	public abstract Account addAccount(Account account);
	public abstract Account registerNetbankingAccount(Long accountNumber, NetBankingAccount netbankingAccount);
	public abstract NetBankingAccount resestPassword(NetBankingAccount netbankingAccount);

	
}
