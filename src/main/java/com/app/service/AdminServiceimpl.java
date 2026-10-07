package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Account;
import com.app.repository.AdminRepository;

@Service
public class AdminServiceimpl implements AdminServiceI {
	
//	@Autowired
	AdminRepository bankRepository;
	AdminServiceimpl(AdminRepository bankRepository){
		this.bankRepository=bankRepository;
	}

	@Override
	public Account createAccount(Account account) {
		Account acc= bankRepository.save(account);
		 return acc;
	}

	@Override
	public List<Account> getAllAccount() {
		List<Account> allAccount=(List<Account>) bankRepository.findAll();
		return allAccount;
	}

	@Override
	public Account getAccountById(int id) {
		Account getSingleAccount=bankRepository.findById(id).orElse(null);
		return getSingleAccount;
	}

	@Override
	public Account updateAccountById(int id, Account account) {
		Account existingAccount = bankRepository.findById(id).get();
		
		
		existingAccount.setAccountNo(account.getAccountNo());
		existingAccount.setUserName(account.getUserName());
		existingAccount.setImage(account.getImage());
		existingAccount.setDob(account.getDob());
		existingAccount.setContact(account.getContact());
		existingAccount.setGender(account.getGender());
		existingAccount.setAge(account.getAge());
		existingAccount.setAccountType(account.getAccountType());
		existingAccount.setBalance(account.getBalance());
		existingAccount.setTlist(account.getTlist());

		
		bankRepository.save(existingAccount);
		
		return existingAccount;
	}

	@Override
	public List<Account> deleteAccountById(int id) {
		bankRepository.deleteById(id);
		return (List<Account>)bankRepository.findAll();
		
	}

}
