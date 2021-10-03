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
@Table(name="USER_REGISTRATION")
public class UserRegistration {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Userseq")
	@SequenceGenerator(name="Userseq",sequenceName="Userseq",allocationSize = 1)

	@Column(name="SERVICE_ID")
	public long service_id;
	
	@Column(name="ADHAR_CARD")
	public long aadhar_card;
	
	@Column(name="FIRST_NAME")
	public String First_name;
	
	@Column(name="MIDDLE_NAME")
	public String Middle_name;
	
	@Column(name="LAST_NAME")
	public String Last_name;
	
	@Column(name="PHONE_NUMBER")
	public long Phone_Number;
	
	@Column(name="EMAIL_ID")
	public String Email_id;
	
	@Column(name="FATHER_NAME")
	public String father_name;
	
	@Column(name="MOTHER_NAME")
	public String mother_name;
	
	@Column(name="OCCUPATION")
	public String occupation;
	
	@Column(name="SOURCE_OF_INCOME")
	public String source_of_income;

	@Column(name="ANNUAL_INCOME")
	public int annual_income;
	
	@Column(name="ACCOUNT_TYPE")
	public String account_type;
	
	@Column(name="DATE_OF_BIRTH")
	public String date_of_birth;
	
	
	@Column(name="ACCOUNT_STATUS")
	public String account_status;
	
	@Column(name="NET_BANKING")
	public String net_banking;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="Address_ID")
	public  Address address;

	//getters adn setters
	
	public long getAadhar_card() {
		return aadhar_card;
	}


	public void setAadhar_card(long aadhar_card) {
		this.aadhar_card = aadhar_card;
	}

	public String getFirst_name() {
		return First_name;
	}

	public void setFirst_name(String first_name) {
		First_name = first_name;
	}

	public String getMiddle_name() {
		return Middle_name;
	}

	public void setMiddle_name(String middle_name) {
		Middle_name = middle_name;
	}

	public String getLast_name() {
		return Last_name;
	}

	public void setLast_name(String last_name) {
		Last_name = last_name;
	}

	public long getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(long phone_Number) {
		Phone_Number = phone_Number;
	}

	public String getEmail_id() {
		return Email_id;
	}

	public void setEmail_id(String email_id) {
		Email_id = email_id;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getMother_name() {
		return mother_name;
	}

	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getSource_of_income() {
		return source_of_income;
	}

	public void setSource_of_income(String source_of_income) {
		this.source_of_income = source_of_income;
	}

	public int getAnnual_income() {
		return annual_income;
	}

	public void setAnnual_income(int annual_income) {
		this.annual_income = annual_income;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}


	public String getAccount_status() {
		return account_status;
	}

	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}
	
	public String getNet_banking() {
		return net_banking;
	}

	public void setNet_banking(String net_banking) {
		this.net_banking = net_banking;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

	public long getService_id() {
		return service_id;
	}

	public void setService_id(long service_id) {
		this.service_id = service_id;
	}
	
	
	

	public UserRegistration(long aadhar_card, String first_name, String middle_name, String last_name, long phone_Number,
			String email_id, String father_name, String mother_name, String occupation, String source_of_income,
			int annual_income, String account_type, String date_of_birth,String account_status,
			String net_banking, Address address) {
		super();
		this.aadhar_card = aadhar_card;
		this.First_name = first_name;
		this.Middle_name = middle_name;
		this.Last_name = last_name;
		this.Phone_Number = phone_Number;
		this.Email_id = email_id;
		this.father_name = father_name;
		this.mother_name = mother_name;
		this.occupation = occupation;
		this.source_of_income = source_of_income;
		this.annual_income = annual_income;
		this.account_type = account_type;
		this.date_of_birth = date_of_birth;
		this.account_status = account_status;
		this.net_banking = net_banking;
		this.address = address;
	}

	public UserRegistration() {
		super();
	}

	@Override
	public String toString() {
		return "user_Registration [aadhar_card=" + aadhar_card + ", First_name=" + First_name + ", Middle_name="
				+ Middle_name + ", Last_name=" + Last_name + ", Phone_Number=" + Phone_Number + ", Email_id=" + Email_id
				+ ", father_name=" + father_name + ", mother_name=" + mother_name + ", occupation=" + occupation
				+ ", source_of_income=" + source_of_income + ", annual_income=" + annual_income + ", account_type="
				+ account_type + ", date_of_birth=" + date_of_birth + ", service_id=" + service_id + ", account_status="
				+ account_status + ", net_banking=" + net_banking + ", address=" + address + "]";
	}
	
	
	
	
}
