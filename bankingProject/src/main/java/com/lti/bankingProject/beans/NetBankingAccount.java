package com.lti.bankingProject.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "NET_BANKING")
public class NetBankingAccount {
	

	@Id
	@Column (name = "USER_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "NETBANKING_SEQ")
	@SequenceGenerator(name="NETBANKING_SEQ", sequenceName = "netbanking_seq", allocationSize = 1)
	private long userId;
	@Column (name = "LOGIN_PASSWORD")
	private String loginPassword;
	@Column (name = "TRANSACTION_PASSWORD")
	private String transactionPassword;
	@Column (name = "SERVICE_NUMBER")
	private long serviceNumber;
	
	@JoinColumn (name = "ACCOUNT_NUMBER")
	@OneToOne (mappedBy = "netbankingAccount", cascade = CascadeType.ALL)
	private Account account;
	
//	@OneToOne (fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	@JoinColumn(name = "SERVICE_REF_ID")
//	private UserDetail userdetail;
	
	public NetBankingAccount() {
		super();
	}

	public NetBankingAccount(String loginPassword, String transactionPassword, long serviceNumber) {
		super();
		this.loginPassword = loginPassword;
		this.transactionPassword = transactionPassword;
		this.serviceNumber = serviceNumber;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getTransactionPassword() {
		return transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

	public long getServiceNumber() {
		return serviceNumber;
	}

	public void setServiceNumber(long serviceNumber) {
		this.serviceNumber = serviceNumber;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "NetBankingAccount [userId=" + userId + ", loginPassword=" + loginPassword + ", transactionPassword="
				+ transactionPassword + ", serviceNumber=" + serviceNumber + ", account=" + account + "]";
	}
	
	
	

}
