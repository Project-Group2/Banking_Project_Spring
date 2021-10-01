package com.lti.demo.beans;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity
@Table(name="TRANSACTION_DETAILs")
public class Transaction {
	
	@Id
	@Column(name="TRANSACTION_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tr_seq")
	@SequenceGenerator(sequenceName = "reference_seq", initialValue = 111, allocationSize = 1, name="tr_seq1")
	private int transactionId;
	
	
	@Column(name ="TRANSACTION_DATE")
	private String transactionDate;
	
	@Column(name= "TRANSACTION_TYPE")
	private String transactionType;
	
	@Column(name="TRANSACTION_PASS")
	private String transactionPass;
	
	@Column(name="FROM_ACCOUNT")
	private long fromAccount;
	
	//@Column(name="BENEFICIARY_ACC_NO")
	//private long beneficiaryAcNo;
    
	@Column(name = "TRANSACTION_AMOUNT")
	private double transactionAmount;
	
	@Column(name="TRANSACTION_STATUS")
	private String status;
	
	@Column(name="TR_REMARKS")
	private String remarks;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "ACCOUNT_NUMBER")
	private Account account;
	

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "BENEFICIARY_ACC_NO")
	private Beneficiary beneficiary;
	
	public Transaction(int transactionId, String transactionDate, String transactionType, long fromAccount,
			long beneficiaryAcNo, double transactionAmount, String status, String remarks) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.fromAccount = fromAccount;
		this.transactionAmount = transactionAmount;
		this.status = status;
		this.remarks = remarks;
	}
	
	

	public String getTransactionPass() {
		return transactionPass;
	}



	public void setTransactionPass(String transactionPass) {
		this.transactionPass = transactionPass;
	}



	public Transaction(String transactionPass) {
		super();
		this.transactionPass = transactionPass;
	}
	
	



	public Beneficiary getBeneficiary() {
		return beneficiary;
	}



	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}



	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", transactionType=" + transactionType + ", transactionPass=" + transactionPass + ", fromAccount="
				+ fromAccount + ", transactionAmount=" + transactionAmount
				+ ", status=" + status + ", remarks=" + remarks + "]";
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String  getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}



	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}


	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Account getAccount() {
		return account;
	}



	public void setAccount(Account account) {
		this.account = account;
	}



	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Transaction() {
		super();
	}
	

}
