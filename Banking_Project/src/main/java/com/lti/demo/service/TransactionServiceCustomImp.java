package com.lti.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.demo.beans.Account;
import com.lti.demo.beans.Transaction;
import com.lti.demo.dao.TransactionDaoCustom;

@Service("transactionServiceCustom")
public class TransactionServiceCustomImp implements TransactionServiceCustom{

	@Autowired
	 TransactionDaoCustom transactionDaoCustom;
	
	@Override
	public Transaction transactionWithAccount(Long accountNumber, Transaction transaction) {
		return transactionDaoCustom.transactionWithAccount(accountNumber, transaction);
	
	}

	@Override
	public Transaction transactionWithBeneficiary(Long beneficiaryAcNo, Transaction transaction) {
	
		return transactionDaoCustom.transactionWithBeneficiary(beneficiaryAcNo, transaction);
	}

	@Override
	public Long getAccountNobyUserId(Long netbankingUserId) {
		return transactionDaoCustom.getAccountNobyUserId(netbankingUserId);
	}

	@Override
	public String getTransactionPassword(Long netbankingUserId) {
		return transactionDaoCustom.getTransactionPassword(netbankingUserId);
		
	}
	

}