package com.lti.bankingProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.lti.bankingProject.beans.Account;
import com.lti.bankingProject.beans.UserRegistration;

@Service
public class MailService {

	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	// once Id is generated user get mail with id number
	public void UserInserted(UserRegistration user) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail_id());
		mail.setSubject("Registration Successful");
		mail.setText("Dear " + user.getFirst_name() + " " + user.getLast_name()
				+ ",\n\nYour Registration for Bank Account is successful."
				+ "\n\nService Id: " + user.getService_id()
				+ "\nAccount Status: Pending");

		javaMailSender.send(mail);
	}
	
	public void userAccepted(Account account) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(account.getUserRegistration().getEmail_id());
		mail.setSubject("Account Created");
		if(account.getNetbankingAccount() == null) {
			mail.setText("Dear " + account.getUserRegistration().getFirst_name() + " " + account.getUserRegistration().getLast_name()
					+ ",\n\nYour Account has been created."
					+ "\n\nService Id: " + account.getUserRegistration().service_id
					+ "\nAccount Number: " + account.getAccountNumber()
					+ "\nNetBanking Id: NA"
					+ "\nAccount Status: Accepted");
		}
		else {
			mail.setText("Dear " + account.getUserRegistration().getFirst_name() + " " + account.getUserRegistration().getLast_name()
					+ ",\n\nYour Account has been created."
					+ "\n\nService Id: " + account.getUserRegistration().service_id
					+ "\nAccount Number: " + account.getAccountNumber()
					+ "\nNetBanking Id: " + account.getNetbankingAccount().getUserId()
					+ "\nNetBanking Login Password: " + account.getNetbankingAccount().getLoginPassword()
					+ "\nNetBanking Transaction Password: " + account.getNetbankingAccount().getTransactionPassword()
					+ "\nAccount Status: Accepted");
			
		}
		javaMailSender.send(mail);
	}
	
	
	public void UserRejected(UserRegistration user) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail_id());
		mail.setSubject("Application for Bank Account Rejected");
		mail.setText("Dear " + user.getFirst_name() + " " + user.getLast_name()
				+ ",\n\nYour Registration for Bank Account is rejected."
				+ "\n\nService Id: " + user.getService_id()
				+ "\nAccount Status: Rejected");

		javaMailSender.send(mail);
	}

}
