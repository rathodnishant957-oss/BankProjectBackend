package com.app.repository;
import org.springframework.data.repository.CrudRepository;

import com.app.model.Account;

public interface AdminRepository extends CrudRepository<Account, Integer>{


}
