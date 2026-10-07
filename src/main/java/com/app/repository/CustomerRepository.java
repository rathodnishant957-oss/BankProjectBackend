package com.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Account;

public interface CustomerRepository extends JpaRepository<Account ,Integer> {
	 Account findByAccountNoAndPassword(long accountNo, String password);

	 Account findByAccountNo(long accountNo);

}
