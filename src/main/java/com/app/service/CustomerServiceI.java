package com.app.service;

import java.util.List;

import com.app.model.Account;
import com.app.model.TraHistory;

public interface CustomerServiceI {
	Account login(Account acc);
	Account viewProfile(Account acc);
	double checkBalance(int id);
	double depositeMoney(long accountNo, double amount);
	double withdrawMoney(long accountNo,double amount);
	List<TraHistory> viewTransactionHistory();

	
}
