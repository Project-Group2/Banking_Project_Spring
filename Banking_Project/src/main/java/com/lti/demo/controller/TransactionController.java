package com.lti.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.demo.beans.Account;
import com.lti.demo.beans.Beneficiary;
import com.lti.demo.beans.Transaction;
import com.lti.demo.service.TransactionService;
import com.lti.demo.service.TransactionServiceCustom;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	TransactionServiceCustom transactionServiceCustom;
	
	@CrossOrigin("*")
	@RequestMapping("/all")
	@GetMapping
	public List<Transaction> getAllTransaction(){
		return transactionService.getAllTransaction();
	}
	
	@CrossOrigin("*")
	@RequestMapping(value = "/addTransaction")
	@PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return this.transactionService.addTransaction(transaction);
  
    }
	
	@CrossOrigin("*")
	@RequestMapping(value = "/transactionWithAccount/{accountNo}")
	@PostMapping
	public Transaction transactionWithAccount(@PathVariable("accountNo") Long accountNumber,@RequestBody Transaction transaction) {
		return transactionServiceCustom.transactionWithAccount(accountNumber, transaction);
		
	}
	
	@CrossOrigin("*")
	@RequestMapping(value = "/transactionWithBeneficiary/{beneficiaryAcNo}")
	@PostMapping
	public Transaction transactionWithBeneficiary(@PathVariable("beneficiaryAcNo")Long beneficiaryAcNo, @RequestBody Transaction transaction) {
		return transactionServiceCustom.transactionWithBeneficiary(beneficiaryAcNo, transaction);
	}
	
	@CrossOrigin("*")
	//localhost:8282/transaction/accountNoFromUserId/2
	@RequestMapping(value ="/accountNoFromUserId/{userId}")
	@GetMapping
	public Long getAccountNobyUserId(@PathVariable("userId") Long netbankingUserId) {
		return  transactionServiceCustom.getAccountNobyUserId(netbankingUserId);
	}
	
	@CrossOrigin("*")
	@RequestMapping(value ="/getTransactionPass/{userId}")
	@GetMapping
	public String getTransactionPassword(@PathVariable("userId") Long netbankingUserId) {
		return transactionServiceCustom.getTransactionPassword(netbankingUserId);
	}
	
	@CrossOrigin("*")
	@RequestMapping(value ="/displayTransaction/{fromAccount}")
	@GetMapping
	public Transaction displayTransaction(@PathVariable("fromAccount") long accountNumber) {
		return transactionService.displayTransaction(accountNumber);
	}
	
	@CrossOrigin("*")
	@RequestMapping(value ="/updateBalance/{fromAccount}")
	@GetMapping
	public Account updateBalance(@PathVariable("fromAccount")Long accountNumber) {
		return transactionServiceCustom.updateBalance(accountNumber);
	}
	
	@CrossOrigin("*")
	@RequestMapping(value ="/getBalance/{fromAccount}")
	@GetMapping
	public Account getAccountBalance(@PathVariable("fromAccount")Long accountNumber) {
		return transactionServiceCustom.getAccountBalance(accountNumber);
	}
	
	@CrossOrigin("*")
	@RequestMapping(value ="/getTransactionAmount/{fromAccount}")
	@GetMapping
	public Transaction getTransactionAmount(@PathVariable("fromAccount") Long fromAccount) {
		return transactionServiceCustom.getTransactionAmount(fromAccount);
	}
	
}
