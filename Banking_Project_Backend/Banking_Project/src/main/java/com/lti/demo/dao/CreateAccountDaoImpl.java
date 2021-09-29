package com.lti.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.demo.beans.Account;
import com.lti.demo.beans.NetBankingAccount;

@Repository
public class CreateAccountDaoImpl implements CreateAccountDao{
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public Account accountWithoutNetbanking(Account account) {
		// TODO Auto-generated method stub
		em.persist(account);
		return account;
	}

	@Transactional
	@Override
	public Account accountWithNetbanking(Account account) {
		// TODO Auto-generated method stub
		em.persist(account);
		return account;
	}

	@Transactional
	@Override
	public Account registerNetbankingAccount(Long accountNumber, NetBankingAccount netbankingAccount) {
		// TODO Auto-generated method stub
		Account tempAccount = em.find(Account.class, (long)accountNumber);
		if(tempAccount.getNetbankingAccount() != null) {
			System.out.println("NetBanking exists for this account");
		}
		else {
			tempAccount.setNetbankingAccount(netbankingAccount);
			tempAccount.setIfNetBanking("YES");
			em.persist(netbankingAccount);
			em.merge(tempAccount);
		}
		return tempAccount;
		
	}
}
