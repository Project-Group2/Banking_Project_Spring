package com.lti.bankingProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.bankingProject.beans.Beneficiary;

public interface BeneficiaryDao extends JpaRepository<Beneficiary, Long> {

}
