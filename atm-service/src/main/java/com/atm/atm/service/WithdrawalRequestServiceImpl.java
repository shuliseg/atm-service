package com.atm.atm.service;

import com.atm.atm.ErrorMsgEnum;
import com.atm.atm.dao.WithdrawalsDao;
import com.atm.atm.entity.WithdrawalRequest;
import com.atm.atm.exception.WithdrawalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WithdrawalRequestServiceImpl implements WithdrawalRequestService {
    private final Integer MAX_WITHDRAWALS_TO_DAY = 5;
    private final Double MAX_WITHDRAWALS_SUM_TO_DAY = 2000d;

    private static final Logger logger = LoggerFactory.getLogger(WithdrawalRequestServiceImpl.class);

    @Autowired
    private WithdrawalsDao withdrawalsDao;


    @Override
    public String withdrawalMoney(WithdrawalRequest withdrawalRequest) {
        try {
            if (!withdrawalPossible(withdrawalRequest)) {
                logger.error(ErrorMsgEnum.WITHDRAWAL_NOT_POSSIBLE.toString());
                return ErrorMsgEnum.WITHDRAWAL_NOT_POSSIBLE.toString();
            }
            logger.info(ErrorMsgEnum.WITHDRAWAL_IS_POSSIBLE.toString());
            doWithdrawal(withdrawalRequest);
            logger.info(ErrorMsgEnum.WITHDRAWAL_DONE.toString());
            return ErrorMsgEnum.WITHDRAWAL_DONE.toString();
        } catch (WithdrawalException e) {
            return e.getErrorMsg();
        }
    }

    private void doWithdrawal(WithdrawalRequest withdrawalRequest) {

    }

    private boolean withdrawalPossible(WithdrawalRequest withdrawalRequest) throws WithdrawalException {
        return checkWithdrawalsCountToday(withdrawalRequest) && checkWithdrawalsSumToday(withdrawalRequest);
    }

    private Boolean checkWithdrawalsSumToday(WithdrawalRequest withdrawalRequest) throws WithdrawalException {
        return withdrawalsDao.getWithdrawalsSumByCreditCardAndSecretCode(withdrawalRequest) >= MAX_WITHDRAWALS_SUM_TO_DAY ? Boolean.FALSE : Boolean.TRUE;
    }

    private Boolean checkWithdrawalsCountToday(WithdrawalRequest withdrawalRequest) throws WithdrawalException {
        return withdrawalsDao.getWithdrawalsCountByCreditCardAndSecretCode(withdrawalRequest) >= MAX_WITHDRAWALS_TO_DAY ? Boolean.FALSE : Boolean.TRUE;
    }
}
