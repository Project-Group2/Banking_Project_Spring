package com.lti.bankingProject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.bankingProject.beans.Beneficiary;
import com.lti.bankingProject.dao.BeneficiaryDao;

@Service
public class BeneficiaryService {
	
	@Autowired
	BeneficiaryDao beneficiaryDao;
	
	  public List<Beneficiary> getAllBeneficary() {
	         return this.beneficiaryDao.findAll();
	     }
	 
	    

		public Beneficiary addBeneficiary(Beneficiary beneficiary) {
			return this.beneficiaryDao.save(beneficiary);
		}
		
		public List<Long> getBeneficiaryAcNo(){
			return beneficiaryDao.getBeneficiaryAcNo();
		}
			

}