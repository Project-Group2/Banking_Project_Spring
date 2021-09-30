package com.lti.demo.dao;

import com.lti.demo.beans.Account;
import com.lti.demo.beans.Transaction;

public interface TransactionDaoCustom {
	public abstract Transaction transactionWithAccount(Long accountNumber, Transaction transaction);
	
}
