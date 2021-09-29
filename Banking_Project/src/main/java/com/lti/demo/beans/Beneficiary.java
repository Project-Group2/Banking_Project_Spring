package com.lti.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="benefiary_details")
public class Beneficiary {
	
	@Id
	@Column(name = "beneficiary_acc_no")
	private long beneficiaryAcNo;
	
	@Column(name = "beneficiary_name")
	private String benefiaryName;

	@Column(name = "nick_name")
	private String nickName;

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
