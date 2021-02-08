package com.kodilla.accounts.controller;

import com.kodilla.accounts.domain.Account;
import com.kodilla.accounts.domain.AccountDto;
import com.kodilla.accounts.domain.AccountResponse;
import com.kodilla.accounts.mapper.AccountMapper;
import com.kodilla.accounts.service.DbAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/v1")
public class AccountController {
    @Autowired
    private DbAccountService dbAccountService;
    @Autowired
    private AccountMapper accountMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{customerId}")
    public AccountResponse getAllCustomerAccount(@PathVariable Long customerId){

        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account(1421L,"72249000059957936727967706","PLN",new BigDecimal(6525.11)));
        List<AccountDto> accountDtoList = accountMapper.mapToAccountDtoList(accountList);
        return new AccountResponse(accountDtoList);
    }

}

