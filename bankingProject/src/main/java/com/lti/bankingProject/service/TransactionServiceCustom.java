package com.lti.bankingProject.service;

import com.lti.bankingProject.beans.Account;
import com.lti.bankingProject.beans.Transaction;

public interface TransactionServiceCustom {

	public abstract Transaction transactionWithAccount(Long accountNumber, Transaction transaction);
	
}
