package com.lti.demo.service;

import com.lti.demo.beans.Account;
import com.lti.demo.beans.Transaction;

public interface TransactionServiceCustom {

	public abstract Transaction transactionWithAccount(Long accountNumber, Transaction transaction);
	
}
