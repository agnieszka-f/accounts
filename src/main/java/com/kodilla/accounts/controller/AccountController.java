package com.kodilla.accounts.controller;

import com.kodilla.accounts.domain.Account;
import com.kodilla.accounts.domain.AccountDto;
import com.kodilla.accounts.domain.GetAccountsResponse;
import com.kodilla.accounts.mapper.AccountMapper;
import com.kodilla.accounts.service.DbAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/v1/accounts")
public class AccountController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private DbAccountService dbAccountService;
    @Autowired
    private AccountMapper accountMapper;

    @Value("${application.allow-get-accounts}")
    private boolean allowGetAccount;


    @RequestMapping(method = RequestMethod.GET, value = "/{customerId}")
    public GetAccountsResponse getAccounts(@PathVariable Long customerId){

        LOGGER.info("Get accounts for customerID: {}",customerId);

        if(!allowGetAccount){
            LOGGER.info("Getting accounts is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
        }

            List<Account> accountList = new ArrayList<>();
            accountList.add(new Account(1421L, "72249000059957936727967706", "PLN", new BigDecimal(6525.11)));
            accountList.add(new Account(1421L, "81979000059957936727967564", "EUR", new BigDecimal(728.56)));
            List<AccountDto> accountDtoList = accountMapper.mapToAccountDtoList(accountList);
            return new GetAccountsResponse(accountDtoList);

    }
    
    @RequestMapping(method = RequestMethod.GET, value="/{nrb}")
    public GetAccountsResponse getAccountByNrb(@PathVariable String nrb){

        LOGGER.info("Get nrb: {}");

        if(!allowGetAccount){
            LOGGER.info("Getting accounts is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
        }

        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account(1421L, "72249000059957936727967706", "PLN", new BigDecimal(6525.11)));
        List<AccountDto> accountDtoList = accountMapper.mapToAccountDtoList(accountList);
        return new GetAccountsResponse(accountDtoList);

    }

}

