package com.lti.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.demo.beans.Account;
import com.lti.demo.beans.NetBankingAccount;
import com.lti.demo.service.CreateAccountJpaService;
import com.lti.demo.service.CreateAccountService;

@RestController
@RequestMapping("/account")
public class CreateAccountController {
	
	@Autowired
	CreateAccountService createAccountService;
	
	
	
	@RequestMapping(value = "/accountWithoutNetbanking")
	@PostMapping
    public Account accountWithoutNetbanking(@RequestBody Account account) {
		
        return this.createAccountService.accountWithoutNetbanking(account);
    }
	
	
	@RequestMapping(value = "/accountWithNetbanking")
	@PostMapping
    public Account accountWitNetbanking(@RequestBody Account account) {
		System.out.println(account);
		return this.createAccountService.accountWithNetbanking(account);
    }
	
	
	@RequestMapping(value = "/registerNetbankingAccount/{accountNo}")
	@PostMapping
    public Account registerNetbankingAccount(@PathVariable("accountNo") Long accountNumber, @RequestBody NetBankingAccount netBankingAccount) {
		System.out.println(netBankingAccount);
		return this.createAccountService.registerNetbankingAccount(accountNumber, netBankingAccount);
    }
	

	
	
//	@RequestMapping(value = "/addNetBankingtoAccount")
//	@PostMapping
//    public Account netBankingRegister(@RequestBody Long accountNumber, NetBankingAccount netbanking) {
//		
//        return this.createAccountJpaService.netBankingRegister(netbanking, accountNumber);
//        
//	}
//	
	
	
        
}
