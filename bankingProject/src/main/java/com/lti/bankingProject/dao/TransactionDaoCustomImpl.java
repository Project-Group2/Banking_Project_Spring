package com.lti.bankingProject.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;

import com.lti.bankingProject.beans.Account;
import com.lti.bankingProject.beans.Beneficiary;
import com.lti.bankingProject.beans.NetBankingAccount;
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


	@Override
	@Transactional
	public Transaction transactionWithBeneficiary(Long beneficiaryAcNo, Transaction transaction) {
		Beneficiary tempBeneficiary = em.find(Beneficiary.class, beneficiaryAcNo);
		if(tempBeneficiary !=null) {
			transaction.setBeneficiary(tempBeneficiary);
			em.persist(transaction);;
		}
		else {
			System.out.println("Beneficiary does not exist");
		}
		return transaction;
		
	}


	@Transactional
	@Override
	public Long getAccountNobyUserId(Long netbankingUserId) {
		
		Query qry = em.createQuery("Select a from Account a JOIN a.netbankingAccount nb where nb.userId=:userid");
		qry.setParameter("userid", netbankingUserId);
		Account tempAccount = (Account) qry.getSingleResult();
		Long acountNumber = tempAccount.getAccountNumber();
		return acountNumber;
	}


	@Transactional
	@Override
	public String getTransactionPassword(Long netbankingUserId) {
		Query qry = em.createQuery("Select nb from NetBankingAccount nb where nb.userId=:userid");
		qry.setParameter("userid", netbankingUserId);
		NetBankingAccount netBanking = (NetBankingAccount) qry.getSingleResult();
		String transactionPassword = netBanking.getTransactionPassword();
		return transactionPassword;
		
	}

	
	

}