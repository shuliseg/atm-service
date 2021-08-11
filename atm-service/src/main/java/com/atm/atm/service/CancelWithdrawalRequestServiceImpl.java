package com.atm.atm.service;

import com.atm.atm.dao.WithdrawalsDao;
import com.atm.atm.entity.WithdrawalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelWithdrawalRequestServiceImpl implements CancelWithdrawalRequestService{

    @Autowired
    private WithdrawalsDao withdrawalsDao;

    @Override
    public String cancelWithdrawalMoney(WithdrawalRequest withdrawalRequest) {
        withdrawalsDao.addAmountForCustomerByCreditCard(withdrawalRequest);
        return null;
    }


}
