package com.lti.bankingProject.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="add_seq1 ")
	@SequenceGenerator(name="add_seq1 ",sequenceName="add_seq ",allocationSize = 1)
	@Column(name="Address_ID")
	public int address_id;
	
    @Column(name="CITY")
	public String city;
    @Column(name="STATE")
	public String state;
    @Column(name="COUNTRY")
	public String country;
    
    @Column(name="PINCODE")
    public Long pincode;


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Long getPincode() {
		return pincode;
	}


	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}


	public int getaddress_id() {
		return address_id;
	}


	public void setService_id(int service_id) {
		this.address_id = service_id;
	}


	public Address(String address, String city, String state, String country, Long pincode, int address_id) {
		super();
		
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.address_id = address_id;
	}


	public Address(String address, String city, String state, String country, Long pincode) {
		super();
		
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}


	public Address() {
		super();
	}
    
    
    
    
}

