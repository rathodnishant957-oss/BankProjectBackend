package com.app.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Account;
import com.app.model.TraHistory;
import com.app.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerServiceI{
	Scanner sc= new Scanner(System.in);
	@Autowired
	private CustomerRepository bankRepository;
	
	@Override
	public Account login(Account acc) {

	    Account accountNo = bankRepository.findByAccountNoAndPassword(
	            acc.getAccountNo(),
	            acc.getPassword()
	    );

	    return accountNo;
	}
	@Override
	public Account viewProfile(Account acc) {

	    Optional<Account> optional = bankRepository.findById(acc.getId());

	    if (optional.isPresent()) {
	        return optional.get();
	    }

	    return null;
	}
	@Override
	public double checkBalance(int id) {

	    Account account = bankRepository.findById(id).orElse(null);

	    if (account == null) {
	        throw new RuntimeException("Account not found with id: " + id);
	    }
	    return account.getBalance();
	}
	@Override
	public double depositeMoney(long accountNo, double amount) {

	    Account account = bankRepository.findByAccountNo(accountNo);

	    if (account == null) {
	        return 0;
	    }

	    // Update balance
	    double newBalance = account.getBalance() + amount;
	    account.setBalance(newBalance);

	    // Create transaction history
	    TraHistory history = new TraHistory();
	    history.setTraType("deposit");
	    history.setTraAmount(amount);
	    history.setTraDate(LocalDate.now().toString());
	    history.setTraTime(LocalTime.now().toString());

	    // Add transaction to account
	    account.getTlist().add(history);

	    // Save account + transaction
	    bankRepository.save(account);

	    return newBalance;
	}

	@Override
	public double withdrawMoney(long accountNo, double amount) {

	    Account account = bankRepository.findByAccountNo(accountNo);

	    if (account == null) {
	        return 0;
	    }

	    if (account.getBalance() < amount) {
	        System.out.println("Insufficient Balance");
	        return -1;
	    }
	    // Update balance
	    double newBalance = account.getBalance() - amount;
	    account.setBalance(newBalance);

	    // Create transaction history
	    TraHistory history = new TraHistory();
	    history.setTraType("Withdrawal");
	    history.setTraAmount(amount);
	    history.setTraDate(LocalDate.now().toString());
	    history.setTraTime(LocalTime.now().toString());

	    // Add transaction
	    account.getTlist().add(history);

	    // Save
	    bankRepository.save(account);

	    return newBalance;
	}
	
	@Override
	public List<TraHistory> viewTransactionHistory() {

	    List<Account> accounts = bankRepository.findAll();

	    List<TraHistory> transactions = new ArrayList<>();

	    for (Account account : accounts) {
	        if (account.getTlist() != null) {
	            transactions.addAll(account.getTlist());
	        }
	    }

	    return transactions;
	}
}
