package com.lti.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lti.demo.beans.Beneficiary;

public interface BeneficiaryDao extends JpaRepository<Beneficiary, Long> {

	@Query("Select b.beneficiaryAcNo from Beneficiary b")
	public List<Long> getBeneficiaryAcNo();
	
}
