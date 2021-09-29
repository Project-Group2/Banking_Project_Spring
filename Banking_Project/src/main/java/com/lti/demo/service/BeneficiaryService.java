package com.lti.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.demo.beans.Beneficiary;
import com.lti.demo.dao.BeneficiaryDao;

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

}
