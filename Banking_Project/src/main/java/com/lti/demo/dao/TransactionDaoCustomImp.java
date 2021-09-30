package com.lti.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.demo.beans.Account;
import com.lti.demo.beans.Transaction;

@Repository
public class TransactionDaoCustomImp implements TransactionDaoCustom {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	@Transactional
	public Transaction transactionWithAccount(Long accountNumber, Transaction transaction) {
		Account tempAccount = em.find(Account.class, (long)accountNumber);
		if(tempAccount != null) {
		transaction.setAccount(tempAccount);
		em.persist(transaction);
		}
		else {
			System.out.println("Account does not exist");
		}
		return transaction;
		
	}
	

}
