package com.atm.atm.dao;

import com.atm.atm.entity.WithdrawalRequest;
import com.atm.atm.exception.WithdrawalException;

public interface WithdrawalsDao {
    public int getWithdrawalsCountByCreditCardAndSecretCode(WithdrawalRequest withdrawalRequest) throws WithdrawalException;

    public Double getWithdrawalsSumByCreditCardAndSecretCode(WithdrawalRequest withdrawalRequest) throws WithdrawalException;

    public String addAmountForCustomerByCreditCard(WithdrawalRequest withdrawalRequest) throws WithdrawalException;

    public String removeWithdrawalRecord(WithdrawalRequest withdrawalRequest) throws WithdrawalException;
}
