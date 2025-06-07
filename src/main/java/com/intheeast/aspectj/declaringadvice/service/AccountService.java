package com.intheeast.aspectj.declaringadvice.service;

import java.util.List;

import com.intheeast.aspectj.declaringadvice.model.Account;

public interface AccountService {
    void createAccount(String accountId);
    void deleteAccount(String accountId);
	Account getAccount(String id);
    void updateAccount(Account account);
    
    List<Account> findAccounts(String accountHolderNamePattern);

}
