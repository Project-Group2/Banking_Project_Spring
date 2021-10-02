package com.lti.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lti.demo.beans.Account;
import com.lti.demo.beans.Transaction;

public interface TransactionDao extends JpaRepository<Transaction, Long>{
	

	public Transaction findByFromAccount(long accountNumber);
	
	
	

}
