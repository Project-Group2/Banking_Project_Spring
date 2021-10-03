package com.lti.bankingProject.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table (name = "ACCOUNTS")
public class Account {
	
	@Id
	@Column (name = "ACCOUNT_NUMBER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ACCOUNT_SEQ")
	@SequenceGenerator(name="ACCOUNT_SEQ", sequenceName = "account_seq", allocationSize = 1)
	private long accountNumber;
	
	@Column (name = "ACCOUNT_TYPE")
	private String accountType;
	
	@Column (name = "BALANCE")
	private double balance;
	
	@Column (name = "NET_BANKING")
	private String ifNetBanking;
	
	@OneToOne (fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private NetBankingAccount netbankingAccount;
	

	@OneToOne (fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "SERVICE_ID")
	private UserRegistration userRegistration;


	public Account() {
		super();
	}
	
	//NetBanking is there -- extract
		public Account(long accountNumber, String accountType, double balance, String ifNetBanking,
				NetBankingAccount netbankingAccount, UserRegistration userRegistration) {
			super();
			this.accountNumber = accountNumber;
			this.accountType = accountType;
			this.balance = balance;
			this.ifNetBanking = ifNetBanking;
			this.netbankingAccount = netbankingAccount;
			this.userRegistration = userRegistration;
		}
	
	

	public long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getIfNetBanking() {
		return ifNetBanking;
	}

	public void setIfNetBanking(String ifNetBanking) {
		this.ifNetBanking = ifNetBanking;
	}

	public NetBankingAccount getNetbankingAccount() {
		return netbankingAccount;
	}

	public void setNetbankingAccount(NetBankingAccount netbankingAccount) {
		this.netbankingAccount = netbankingAccount;
	}

	

	public UserRegistration getUserRegistration() {
		return userRegistration;
	}

	public void setUserRegistration(UserRegistration userRegistration) {
		this.userRegistration = userRegistration;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", balance=" + balance
				+ ", ifNetBanking=" + ifNetBanking + ", netbankingAccount=" + netbankingAccount + ", userRegistration="
				+ userRegistration + "]";
	}
	
	
	
		
	
	
	
	

}
