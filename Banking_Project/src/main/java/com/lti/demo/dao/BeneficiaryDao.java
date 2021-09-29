package com.lti.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.demo.beans.Beneficiary;

public interface BeneficiaryDao extends JpaRepository<Beneficiary, Long> {

}
