package com.lti.bankingProject.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BENEFICIARY_DETAILS")
public class Beneficiary {
	
	@Id	
	@Column(name = "BENEFICIARY_ACC_NO")
	private long beneficiaryAcNo;
	
	@Column(name = "BENEFICIARY_NAME")
	private String benefiaryName;

	@Column(name = "NICK_NAME")
	private String nickName;

	


	@Override
	public String toString() {
		return "Beneficiary [beneficiaryAcNo=" + beneficiaryAcNo
				+ ", benefiaryName=" + benefiaryName + ", nickName=" + nickName + "]";
	}


	public Beneficiary() {
		super();
	}

	public Beneficiary(long beneficiaryAcNo, String benefiaryName, String nickName) {
		super();
		this.beneficiaryAcNo = beneficiaryAcNo;
		this.benefiaryName = benefiaryName;
		this.nickName = nickName;
	}

	public long getBeneficiaryAcNo() {
		return beneficiaryAcNo;
	}

	public void setBeneficiaryAcNo(long beneficiaryAcNo) {
		this.beneficiaryAcNo = beneficiaryAcNo;
	}

	public String getBenefiaryName() {
		return benefiaryName;
	}

	public void setBenefiaryName(String benefiaryName) {
		this.benefiaryName = benefiaryName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	

}