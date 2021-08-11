package com.atm.atm.dao;

import com.atm.atm.ErrorMsgEnum;
import com.atm.atm.entity.WithdrawalRequest;
import com.atm.atm.exception.WithdrawalException;
import com.atm.atm.service.WithdrawalRequestServiceImpl;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class WithdrawalsDaoImpl implements WithdrawalsDao{

    private static final Logger logger = LoggerFactory.getLogger(WithdrawalRequestServiceImpl.class);

    @Override
    public int getWithdrawalsCountByCreditCardAndSecretCode(WithdrawalRequest withdrawalRequest) throws WithdrawalException {
        try {
            StringBuilder hql = new StringBuilder();
            hql.append("select count(*) from WITHDRAWALS where CARD_NUMBER =:cardNumber and WITHDRAWAL_DATE = CURRENT DATE");
            Query query = createQuery(hql);
            query.setParameter("cardNumber", withdrawalRequest.getCardNumber());
            return query.getFirstResult();
        } catch (Exception e) {
            logger.error(ErrorMsgEnum.ERROR_IN_GET_WITHDRAWALS_COUNT.toString());
            throw new WithdrawalException(ErrorMsgEnum.ERROR_IN_GET_WITHDRAWALS_COUNT.toString());
        }
    }

    @Override
    public Double getWithdrawalsSumByCreditCardAndSecretCode(WithdrawalRequest withdrawalRequest) throws WithdrawalException {
        try {
            StringBuilder hql = new StringBuilder();
            hql.append("select sum(amount) from WITHDRAWALS where CARD_NUMBER =:cardNumber and WITHDRAWAL_DATE = CURRENT DATE");
            Query query = createQuery(hql);
            query.setParameter("cardNumber", withdrawalRequest.getCardNumber());
            return Double.valueOf(query.getFirstResult());
        } catch (Exception e) {
            logger.error(ErrorMsgEnum.ERROR_IN_GET_WITHDRAWALS_SUM.toString());
            throw new WithdrawalException(ErrorMsgEnum.ERROR_IN_GET_WITHDRAWALS_SUM.toString());
        }
    }

    @Override
    public void addAmountForCustomerByCreditCard(WithdrawalRequest withdrawalRequest) {

    }
}
