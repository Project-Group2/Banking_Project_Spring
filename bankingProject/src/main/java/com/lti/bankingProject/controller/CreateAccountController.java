package com.lti.bankingProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bankingProject.beans.Account;
import com.lti.bankingProject.beans.NetBankingAccount;
import com.lti.bankingProject.service.CreateAccountJpaService;
import com.lti.bankingProject.service.CreateAccountService;

@CrossOrigin (origins="*")
@RestController
@RequestMapping("/account")
public class CreateAccountController {
	
	@Autowired
	CreateAccountService createAccountService;
	
	@Autowired
	CreateAccountJpaService createAccountJpaService;
	
	
	//http://localhost:8282/account/addAccount
	@RequestMapping(value = "/addAccount")
	@PostMapping
    public Account accountWithoutNetbanking(@RequestBody Account account) {
        return this.createAccountService.addAccount(account);
    }
	
	
	
	//http://localhost:8282/account/registerNetbankingAccount/
	@RequestMapping(value = "/registerNetbankingAccount/{accountNo}")
	@PostMapping
    public Account registerNetbankingAccount(@PathVariable("accountNo") Long accountNumber, @RequestBody NetBankingAccount netBankingAccount) {
		System.out.println(netBankingAccount);
		return this.createAccountService.registerNetbankingAccount(accountNumber, netBankingAccount);
    }
	

	//http://localhost:8282/account/getAllAccounts
	@RequestMapping(value="/getAllAccounts")
	@GetMapping
	public List<Account> getAllAccounts(){
		return this.createAccountJpaService.getAllAccounts();
	}
	
	//http://localhost:8282/account/getSingleAccount/2
	@RequestMapping(value="/getSingleAccount/{accountNo}")
	@GetMapping
	public Account getSingleAccount(@PathVariable("accountNo") Long accountNumber){
		return this.createAccountJpaService.getSingleAccount(accountNumber);
	}
	
	
	
	@RequestMapping (value = "/resetPassword")
	@PutMapping 
    public NetBankingAccount resestPassword(@RequestBody NetBankingAccount netbankingAccount) {
		System.out.println(netbankingAccount);
		return this.createAccountService.resestPassword(netbankingAccount);
    }
	
	
        
}
