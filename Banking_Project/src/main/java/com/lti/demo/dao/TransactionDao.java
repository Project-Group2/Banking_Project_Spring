package com.lti.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.demo.beans.Transaction;

public interface TransactionDao extends JpaRepository<Transaction, Long>{
	
	
	//public String neftTransaction(Transaction transaction);
	
	

}
