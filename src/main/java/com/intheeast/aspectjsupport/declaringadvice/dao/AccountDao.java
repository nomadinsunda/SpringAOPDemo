package com.intheeast.aspectjsupport.declaringadvice.dao;

import com.intheeast.aspectjsupport.declaringadvice.model.Account;

public interface AccountDao {
    Account findAccountById(String id);
    void updateAccount(Account account);
}
