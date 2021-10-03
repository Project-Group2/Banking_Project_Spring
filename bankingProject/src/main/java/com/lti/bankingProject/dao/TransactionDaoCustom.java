package com.lti.bankingProject.dao;

import com.lti.bankingProject.beans.Account;
import com.lti.bankingProject.beans.Transaction;

public interface TransactionDaoCustom {
	public abstract Transaction transactionWithAccount(Long accountNumber, Transaction transaction);
	
	public abstract Transaction transactionWithBeneficiary(Long beneficiaryAcNo, Transaction transaction);
	
	public abstract Long getAccountNobyUserId(Long netbankingUserId) ;
	
	public abstract String getTransactionPassword(Long netbankingUserId);	
}
