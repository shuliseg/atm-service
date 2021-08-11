package com.atm.atm.service;

import com.atm.atm.ErrorMsgEnum;
import com.atm.atm.dao.WithdrawalsDao;
import com.atm.atm.entity.WithdrawalRequest;
import com.atm.atm.exception.WithdrawalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelWithdrawalRequestServiceImpl implements CancelWithdrawalRequestService{

    @Autowired
    private WithdrawalsDao withdrawalsDao;

    @Override
    public String cancelWithdrawalMoney(WithdrawalRequest withdrawalRequest) {
        try {
            withdrawalsDao.addAmountForCustomerByCreditCard(withdrawalRequest);
            withdrawalsDao.removeWithdrawalRecord(withdrawalRequest);
        } catch (WithdrawalException e){
            return e.getErrorMsg();
        }
        return ErrorMsgEnum.WITHDRAWAL_CANCELED.toString();
    }


}
