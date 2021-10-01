package com.lti.bankingProject.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
//	@OneToOne (fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	@JoinColumn(name = "SERVICE_REF_ID")
//	private UserDetail userdetail;
	
	public NetBankingAccount() {
		super();
	}

	public NetBankingAccount(Long userId, String loginPassword, String transactionPassword, long serviceNumber) {
		super();
		this.userId = userId;
		this.loginPassword = loginPassword;
		this.transactionPassword = transactionPassword;
		this.serviceNumber = serviceNumber;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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


	@Override
	public String toString() {
		return "NetBankingAccount [userId=" + userId + ", loginPassword=" + loginPassword + ", transactionPassword="
				+ transactionPassword + ", serviceNumber=" + serviceNumber + "]";
	}
	
	
	

}
