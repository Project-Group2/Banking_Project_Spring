package com.lti.bankingProject.dao;

import com.lti.bankingProject.beans.Account;
import com.lti.bankingProject.beans.Transaction;

public interface TransactionDaoCustom {
	public abstract Transaction transactionWithAccount(Long accountNumber, Transaction transaction);
	
}
