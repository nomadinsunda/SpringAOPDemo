package com.intheeast.aspectj.declaringadvice.dao;

import com.intheeast.aspectj.declaringadvice.model.Account;

public interface AccountDao {
    Account findAccountById(String id);
    void updateAccount(Account account);
}
