package com.lti.bankingProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.bankingProject.beans.Account;
import com.lti.bankingProject.beans.Transaction;
import com.lti.bankingProject.dao.TransactionDaoCustom;

@Service("transactionServiceCustom")
public class TransactionServiceCustomImpl implements TransactionServiceCustom{

	@Autowired
	 TransactionDaoCustom transactionDaoCustom;
	
	@Override
	public Transaction transactionWithAccount(Long accountNumber, Transaction transaction) {
		return transactionDaoCustom.transactionWithAccount(accountNumber, transaction);
	
	}
	

}
