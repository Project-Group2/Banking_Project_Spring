package com.lti.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping("/all")
	@GetMapping
	public List<Transaction> getAllTransaction(){
		return transactionService.getAllTransaction();
	}
	
	@RequestMapping(value = "/addTransaction")
	@PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return this.transactionService.addTransaction(transaction);
    }
	
	@RequestMapping(value = "/transactionWithAccount/{accountNo}")
	@PostMapping
	public Transaction transactionWithAccount(@PathVariable("accountNo") Long accountNumber,@RequestBody Transaction transaction) {
		return transactionServiceCustom.transactionWithAccount(accountNumber, transaction);
		
	}
	

}