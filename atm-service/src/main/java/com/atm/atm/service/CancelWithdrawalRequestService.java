package com.atm.atm.service;

import com.atm.atm.entity.WithdrawalRequest;

public interface CancelWithdrawalRequestService {
    public String cancelWithdrawalMoney(WithdrawalRequest withdrawalRequest);
}
