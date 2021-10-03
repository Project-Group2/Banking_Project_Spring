package com.lti.bankingProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bankingProject.beans.Beneficiary;
import com.lti.bankingProject.service.BeneficiaryService;

@RestController
@RequestMapping("/beneficiary")
public class BeneficiaryController {
	
	
	@Autowired
	BeneficiaryService beneficiaryService;
	
	@CrossOrigin("*")
	@RequestMapping("/all")
	@GetMapping
	public List<Beneficiary> getAllBeneficiary(){
		return beneficiaryService.getAllBeneficary();
	}
	
	@CrossOrigin("*")
	@RequestMapping(value = "/addBeneficiary")
	@PostMapping
    public Beneficiary addNewBeneficiary(@RequestBody Beneficiary beneficiary) {
        return this.beneficiaryService.addBeneficiary(beneficiary);
    }
	
	@CrossOrigin("*")
	@RequestMapping("/all/beneficiaryAcNo")
	@GetMapping
	public List<Long> getBeneficiaryAcNo(){
		return beneficiaryService.getBeneficiaryAcNo();
	}


}