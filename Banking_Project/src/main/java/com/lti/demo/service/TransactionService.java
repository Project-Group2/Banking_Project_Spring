package com.lti.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.demo.beans.Account;
import com.lti.demo.beans.Transaction;
import com.lti.demo.dao.CreateAccountDao;
import com.lti.demo.dao.TransactionDao;


@Service
public class TransactionService {
	
	@Autowired
	TransactionDao transactionDao;
	
	 public List<Transaction> getAllTransaction() {
         return this.transactionDao.findAll();
        
     }
	
	public Transaction addTransaction(Transaction transaction)  {
		return this.transactionDao.save(transaction);
	}
	
	
	 public Transaction displayTransaction(Long accountNumber){
		 return this.transactionDao.findByFromAccount(accountNumber);
	 }
	
}
