package com.atm.atm.dao;

import com.atm.atm.entity.WithdrawalRequest;
import com.atm.atm.exception.WithdrawalException;

public interface WithdrawalsDao {
    public int getWithdrawalsCountByCreditCardAndSecretCode(WithdrawalRequest withdrawalRequest) throws WithdrawalException;

    public Double getWithdrawalsSumByCreditCardAndSecretCode(WithdrawalRequest withdrawalRequest) throws WithdrawalException;

    public void addAmountForCustomerByCreditCard(WithdrawalRequest withdrawalRequest);
}
