package com.atm.atm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawalRequest {
    private String cardNumber;
    private String secretCodeNumber;
    private Double amount;
}
