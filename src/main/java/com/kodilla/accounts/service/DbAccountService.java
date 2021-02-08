package com.kodilla.accounts.service;

import com.kodilla.accounts.domain.Account;
import com.kodilla.accounts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbAccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccount(Long customerId){
        return accountRepository.findAll();
    }
}

