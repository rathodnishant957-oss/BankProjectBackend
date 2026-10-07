package com.app.controller;

import com.app.repository.AdminRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Account;
import com.app.model.TraHistory;
import com.app.service.CustomerServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/customer")
public class CustomerController {
	
	private final AdminRepository adminRepository;
	private final AdminController adminController;
	@Autowired
	CustomerServiceImpl csi;

	CustomerController(AdminController adminController, AdminRepository adminRepository) {
		this.adminController = adminController;
		this.adminRepository = adminRepository;
	}
	
	@PostMapping("/login")
	public Account login(@RequestBody Account account) {
	    return csi.login(account);
	}
	
	@GetMapping("/viewprofile/{id}")
	public Account viewProfile(@PathVariable int id) {

	    Account acc = new Account();
	    acc.setId(id);

	    return csi.viewProfile(acc);
	}
	
	@GetMapping("/balance/{id}")
	public double checkBalance(@PathVariable int id) {
	    return csi.checkBalance(id);
	}
	@PostMapping("/deposite/{accountNo}/{amount}")
	public double depositeMoney(
	        @PathVariable long accountNo,
	        @PathVariable double amount) {

	    return csi.depositeMoney(accountNo, amount);
	}
	
	@PostMapping("/withdrawal/{accountNo}/{amount}")
	public double withdrawMoney(
	        @PathVariable long accountNo,
	        @PathVariable double amount) {

	    return csi.withdrawMoney(accountNo, amount);
	}
	@GetMapping("/viewtransaction/{accountNo}")
	public List<TraHistory> viewTransactionHistory() {

	    List<TraHistory> transactions = csi.viewTransactionHistory();

	    return transactions;
	}
}
