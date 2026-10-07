package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.Account;

public interface AdminServiceI {
	

    Account createAccount(Account account);

    List<Account> getAllAccount();

    Account getAccountById(int id);

    Account updateAccountById(int id, Account account);

    List<Account> deleteAccountById(int id);
}
