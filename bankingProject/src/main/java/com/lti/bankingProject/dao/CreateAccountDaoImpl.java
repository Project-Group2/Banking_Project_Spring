package com.lti.bankingProject.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.bankingProject.beans.Account;
import com.lti.bankingProject.beans.Address;
import com.lti.bankingProject.beans.NetBankingAccount;
import com.lti.bankingProject.beans.Transaction;
import com.lti.bankingProject.beans.UserRegistration;

@Repository
public class CreateAccountDaoImpl implements CreateAccountDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	@Override
	public Account addAccount(Long userRegistrationNumber, Account account) {
		// TODO Auto-generated method stub
		UserRegistration tempuserRegistration = em.find(UserRegistration.class, userRegistrationNumber); // userRegistrationNumber is serviceid
		if(tempuserRegistration != null) {
			account.setUserRegistration(tempuserRegistration);
			if(tempuserRegistration.getNet_banking().equalsIgnoreCase("YES")) {
				NetBankingAccount tempnetbanking = account.getNetbankingAccount();
				tempnetbanking.setLoginPassword(tempuserRegistration.First_name);
				tempnetbanking.setTransactionPassword(tempuserRegistration.mother_name);
				tempnetbanking.setUserRegistration(tempuserRegistration);
			}
			else {
				account.setNetbankingAccount(null);
				//NetBankingAccount tempnetBankingAccount = account.getNetbankingAccount();
			}
			em.persist(account);
			tempuserRegistration.setAccount_status("Accepted");
			em.merge(tempuserRegistration);
		}
		else {
			System.out.println("User does not exist");
		}
		return account;
	}

	

	@Transactional
	@Override
	public Account registerNetbankingAccount(Long accountNumber, NetBankingAccount netbankingAccount) {
		// TODO Auto-generated method stub
		Account tempAccount = em.find(Account.class, (long)accountNumber);
		if(tempAccount==null) {
			return null;
		}
		else {
			if(tempAccount.getNetbankingAccount() != null) {
				System.out.println("NetBanking exists for this account");
				return null;
			}
			else {
				tempAccount.setNetbankingAccount(netbankingAccount);
				tempAccount.getNetbankingAccount().setUserRegistration(tempAccount.getUserRegistration());
				tempAccount.setIfNetBanking("YES");
				em.persist(netbankingAccount);
				em.merge(tempAccount);
			}
			return tempAccount;
		}
		
	}



	@Override
	@Transactional
	public NetBankingAccount resestPassword(NetBankingAccount netbankingAccount) {
		// TODO Auto-generated method stub
		NetBankingAccount tempnetbankingAccount = em.find(NetBankingAccount.class, netbankingAccount.getUserId());
		tempnetbankingAccount.setLoginPassword(netbankingAccount.getLoginPassword());
		tempnetbankingAccount.setTransactionPassword(netbankingAccount.getTransactionPassword());	
		em.merge(tempnetbankingAccount);
		return tempnetbankingAccount;
	}



	@Transactional
	@Override
	public Account getAccountbyUserId(Long netbankingUserId) {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("Select a from Account a JOIN a.netbankingAccount nb where nb.userId=:userid");
		qry.setParameter("userid", netbankingUserId);
		Account tempAccount = (Account) qry.getSingleResult();
		return tempAccount;
	}

	
	
	@Override
	public List<Transaction> get5TransactionsFor(Long accountNumber) {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("Select t from Transaction t where t.fromAccount=:accountNo ORDER by t.transactionId DESC");
		qry.setParameter("accountNo", accountNumber);
		List<Transaction> allTransactions = (List) qry.setMaxResults(5).getResultList();
		
		return allTransactions;
	}
	
	



	@Override
	public List<UserRegistration> getPendingRegisters() {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("Select u from UserRegistration u where u.account_status='Pending'");
		List pendingUsers = (List) qry.getResultList();
		return pendingUsers;
	}



	@Override
	public UserRegistration getUserProfileById(Long userId) {
		// TODO Auto-generated method stub
		NetBankingAccount tempNetbanking = em.find(NetBankingAccount.class, userId);
		UserRegistration userProfile = tempNetbanking.getUserRegistration();
		return userProfile;
	}



	@Override
	@Transactional
	public UserRegistration rejectUserRegistration(Long serviecId) {
		// TODO Auto-generated method stub
		UserRegistration rejectUser = em.find(UserRegistration.class, serviecId);
		rejectUser.setAccount_status("Rejected");
		em.merge(rejectUser);
		return rejectUser;
	}



	@Override
	@Transactional
	public UserRegistration updateUser(UserRegistration userUpdate) {
		// TODO Auto-generated method stub
		UserRegistration tempuserUpdate = em.find(UserRegistration.class, userUpdate.getService_id());
		System.out.println(tempuserUpdate);
		System.out.println(userUpdate.getPhone_Number());
		Address tempuserAddress = tempuserUpdate.getAddress();
		tempuserUpdate.setPhone_Number(userUpdate.getPhone_Number());
		tempuserUpdate.setEmail_id(userUpdate.getEmail_id());
		tempuserUpdate.setOccupation(userUpdate.getOccupation());
		tempuserUpdate.setSource_of_income(userUpdate.getSource_of_income());
		tempuserUpdate.setAnnual_income(userUpdate.getAnnual_income());
		tempuserAddress.setCity(userUpdate.getAddress().getCity());
		tempuserAddress.setPincode(userUpdate.getAddress().getPincode());
		tempuserAddress.setState(userUpdate.getAddress().getState());
		tempuserAddress.setCountry(userUpdate.getAddress().getCountry());
		em.merge(tempuserUpdate);
		return tempuserUpdate;
	}




	@Override
	public List<Transaction> getDateWiseTransactionsFor(Long accountNumber, String fromDate, String toDate) {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("Select t from Transaction t where t.transactionDate BETWEEN :frmDt and :toDt");
		qry.setParameter("frmDt",fromDate);
		qry.setParameter("toDt",toDate);
		List<Transaction> transactionsDateWise = (List) qry.getResultList();
		return transactionsDateWise;
	}



	@Override
	public NetBankingAccount loginUser(Long userId) {
		// TODO Auto-generated method stub
		NetBankingAccount tempnetBankingAccount = em.find(NetBankingAccount.class, userId);
		if(tempnetBankingAccount!= null) {
			return tempnetBankingAccount;
		}
		return null;
			
	}



	@Override
	public Account getAccount(Long accountNumber) {
		// TODO Auto-generated method stub
		Account tempAccount = em.find(Account.class, accountNumber);
		if(tempAccount == null) {
			return null;
		}
		return tempAccount;
	}



	@Override
	@Transactional
	public UserRegistration createUser(UserRegistration user) {
		// TODO Auto-generated method stub
		System.out.println(user);
		Query qry = em.createQuery("Select u from UserRegistration u where u.aadhar_card=:aadhar and u.account_status='Accepted'");
		qry.setParameter("aadhar",user.getAadhar_card());
		List<UserRegistration> existingUser = (List) qry.getResultList();
		if(existingUser.isEmpty()) {
			em.persist(user);
			return user;
		}
		return null;
	}
	
	
	
	
	

	
	
	
}
