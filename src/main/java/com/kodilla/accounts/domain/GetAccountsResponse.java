package com.kodilla.accounts.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAccountsResponse {
    private List<AccountDto> accounts = new ArrayList<>();
}

