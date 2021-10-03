package com.lti.demo.service;

import com.lti.demo.beans.Account;
import com.lti.demo.beans.Transaction;

public interface TransactionServiceCustom {

	public abstract Transaction transactionWithAccount(Long accountNumber, Transaction transaction);
	
	public abstract Transaction transactionWithBeneficiary(Long beneficiaryAcNo, Transaction transaction);
	
	public abstract Long getAccountNobyUserId(Long netbankingUserId) ;
	
	public abstract String getTransactionPassword(Long netbankingUserId);
	
	public  abstract Double updateBalance(Long accountNumber);
}
