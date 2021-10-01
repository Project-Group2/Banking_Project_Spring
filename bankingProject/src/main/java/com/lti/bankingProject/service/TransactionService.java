package com.lti.bankingProject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.bankingProject.beans.Transaction;
import com.lti.bankingProject.dao.TransactionDao;

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
	
	
	
//	public String neftTransaction(Transaction transaction)  {
//		
//				
//		return null;
//		
//	}

}
