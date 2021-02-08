package com.kodilla.accounts.domain;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountDto {
    private Long id;
    private String nrb;
    private String currency;
    private BigDecimal availableFunds;
}

