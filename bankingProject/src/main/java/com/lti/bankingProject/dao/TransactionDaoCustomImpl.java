package com.lti.bankingProject.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.bankingProject.beans.Account;
import com.lti.bankingProject.beans.Transaction;

@Repository
public class TransactionDaoCustomImpl implements TransactionDaoCustom {

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
