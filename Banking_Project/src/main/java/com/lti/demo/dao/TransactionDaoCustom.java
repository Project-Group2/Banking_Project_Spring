package com.lti.demo.dao;

import java.util.List;

import com.lti.demo.beans.Account;
import com.lti.demo.beans.Transaction;
import com.lti.demo.exception.HrException;

public interface TransactionDaoCustom {
	public abstract Transaction transactionWithAccount(Long accountNumber, Transaction transaction);
	
	public abstract Transaction transactionWithBeneficiary(Long beneficiaryAcNo, Transaction transaction);
	
	public abstract Long getAccountNobyUserId(Long netbankingUserId) ;
	
	public abstract String getTransactionPassword(Long netbankingUserId);
	
	public  abstract Account updateBalance(Long accountNumber);
	
	public abstract Account getAccountBalance(Long accountNumber);
	
	public abstract Transaction getTransactionAmount(Long fromAccount);
	
}
