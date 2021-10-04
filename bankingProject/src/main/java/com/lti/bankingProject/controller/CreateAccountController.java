package com.lti.bankingProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
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
import com.lti.bankingProject.beans.Transaction;
import com.lti.bankingProject.beans.UserRegistration;
import com.lti.bankingProject.service.CreateAccountJpaService;
import com.lti.bankingProject.service.CreateAccountService;
import com.lti.bankingProject.service.MailService;

@CrossOrigin (origins="http://localhost:4200", allowedHeaders = "Access-Control-Allow-Origin")
@RestController
@RequestMapping("/account")
public class CreateAccountController {
	
	@Autowired
	CreateAccountService createAccountService;
	
	@Autowired
	CreateAccountJpaService createAccountJpaService;
	
	@Autowired
	MailService mailService;
	
	
	
	//http://localhost:8282/account/addAccount
	@RequestMapping(value = "/addAccount/{userRegisterId}")
	@PostMapping
    public Account accountWithoutNetbanking(@PathVariable("userRegisterId") Long userRegistrationNumber,@RequestBody Account account) {
        Account tempAccount = createAccountService.addAccount(userRegistrationNumber, account);
        this.mailService.userAccepted(tempAccount);
		return tempAccount;
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
	
	
	
	@RequestMapping (value="/getAccountById/{netbankingUserId}")
	@GetMapping
	public Account getAccountbyUserId(@PathVariable("netbankingUserId") Long netbankingUserId) {
		return this.createAccountService.getAccountbyUserId(netbankingUserId);
	}
	

	
	
	//recent transactions
	@RequestMapping (value="/getRecentTransactions/{accountNo}")
	@GetMapping
	public List<Transaction> get5TransactionsFor(@PathVariable ("accountNo") Long accountNumber){
		return this.createAccountService.get5TransactionsFor(accountNumber);
	}
	
	//pending users
	@RequestMapping (value="/getPendingRegisters")
	@GetMapping
	public List<UserRegistration> getPendingRegisters(){
		return this.createAccountService.getPendingRegisters();
	}
		
	
	@RequestMapping (value="/userprofile/{userid}")
	@GetMapping
	public UserRegistration getUserProfileById(@PathVariable ("userid") Long userId){
		return this.createAccountService.getUserProfileById(userId);				
	}
	
	
	@RequestMapping (value="/rejectUser/{serviceid}")
	@GetMapping
	public UserRegistration rejectUserRegistration(@PathVariable ("serviceid") Long serviceId) {
		UserRegistration tempUser = createAccountService.rejectUserRegistration(serviceId);
		this.mailService.UserRejected(tempUser);
		return tempUser;
	}

	
	
	@RequestMapping (value = "/updateProfile")
	@PutMapping 
    public UserRegistration updateUser(@RequestBody UserRegistration userUpdate) {
		System.out.println(userUpdate);
		return this.createAccountService.updateUser(userUpdate);
    }
	
	@RequestMapping (value = "/getTransactions/{accountNo}/{fromDt}/{toDt}")
	@GetMapping 
    public List<Transaction> dateWiseTransaction(@PathVariable ("accountNo") Long accountNumber, 
    		@PathVariable ("fromDt") String fromDate, @PathVariable ("toDt") String toDate) {
		System.out.println(accountNumber + fromDate + toDate);
		return this.createAccountService.getDateWiseTransactionsFor(accountNumber, fromDate, toDate);
    }
	
	@RequestMapping (value = "/checkLoginUser/{userid}")
	@GetMapping 
    public NetBankingAccount loginUser(@PathVariable ("userid") Long userId) {
		return this.createAccountService.loginUser(userId);
    }
	
	
	@RequestMapping (value = "/getAccount/{accountNo}")
	@GetMapping 
    public Account getAccount(@PathVariable ("accountNo") Long accountNumber) {
		return this.createAccountService.getAccount(accountNumber);
    }
	
	
	@RequestMapping (value = "/userregister/adduser")
	@GetMapping 
    public UserRegistration createUser(@RequestBody UserRegistration user) {
		UserRegistration tempuser = createAccountService.createUser(user);
		this.mailService.UserInserted(tempuser);
		return tempuser;
    }
	
	
        
}
