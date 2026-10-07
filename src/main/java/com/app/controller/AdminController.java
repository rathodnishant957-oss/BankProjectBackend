package com.app.controller;

import java.nio.channels.AcceptPendingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Account;
import com.app.service.AdminServiceI;
import com.app.service.AdminServiceimpl;



@RestController//written data
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {
	
	//@Autowired
	//constructor injection used in real time
	AdminServiceI bank;
	AdminController(AdminServiceI bank) {
		this.bank=bank;
	}
	
	
	@PostMapping("/save")
	public Account saveStudentData(@RequestBody Account account) {
		bank.createAccount(account);
		return account;
		
	} 
	@GetMapping("/get/{id}")
	public Account getDataByid(@PathVariable int id) {
		Account singleAccount = bank.getAccountById(id);
		return singleAccount;
	}

	@GetMapping("/getall")
	public List<Account> getallData() {
	   List<Account> listOfAccount = bank.getAllAccount();
		return listOfAccount;
	}
	
	@PutMapping("/update/{id}")
	public Account update(@RequestBody Account acc,@PathVariable int id) {
		
		return bank.updateAccountById(id,acc);
		
	}
	@DeleteMapping("/delete/{id}")
	public List<Account> deleteAccountById(@PathVariable int id){
		List<Account> s=bank.deleteAccountById(id);
		return s;
	}
	
	
	
}
