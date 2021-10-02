package com.lti.demo.dao;

import java.util.List;

import com.lti.demo.beans.Account;
import com.lti.demo.beans.Transaction;

public interface TransactionDaoCustom {
	public abstract Transaction transactionWithAccount(Long accountNumber, Transaction transaction);
	
	public abstract Transaction transactionWithBeneficiary(Long beneficiaryAcNo, Transaction transaction);
	
	public abstract Long getAccountNobyUserId(Long netbankingUserId) ;
	
	public abstract String getTransactionPassword(Long netbankingUserId);
	
	
}
