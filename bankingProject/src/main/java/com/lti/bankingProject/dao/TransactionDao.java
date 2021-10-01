package com.lti.bankingProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.bankingProject.beans.Transaction;

public interface TransactionDao extends JpaRepository<Transaction, Long>{
	
	
	//public String neftTransaction(Transaction transaction);
	
	

}
