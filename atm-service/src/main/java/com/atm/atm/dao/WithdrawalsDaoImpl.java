package com.atm.atm.dao;

import com.atm.atm.ErrorMsgEnum;
import com.atm.atm.entity.WithdrawalRequest;
import com.atm.atm.exception.WithdrawalException;
import com.atm.atm.service.WithdrawalRequestServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class WithdrawalsDaoImpl implements WithdrawalsDao{

    private static final String DB_URL = "";
    private static final String USER = "";
    private static final String PASS = "";

    private static final Logger logger = LoggerFactory.getLogger(WithdrawalRequestServiceImpl.class);

    @Override
    public int getWithdrawalsCountByCreditCardAndSecretCode(WithdrawalRequest withdrawalRequest) throws WithdrawalException {
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select count(*) as WITHDRAWALS_COUNT from WITHDRAWALS where CARD_NUMBER = " + withdrawalRequest.getCardNumber() +" and WITHDRAWAL_DATE = CURRENT DATE");
            return rs.getInt("WITHDRAWALS_COUNT");
        } catch (SQLException e) {
            logger.error(ErrorMsgEnum.ERROR_IN_GET_WITHDRAWALS_COUNT.toString());
            throw new WithdrawalException(ErrorMsgEnum.ERROR_IN_GET_WITHDRAWALS_COUNT.toString());
        }
    }

    @Override
    public Double getWithdrawalsSumByCreditCardAndSecretCode(WithdrawalRequest withdrawalRequest) throws WithdrawalException {
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select sum(amount) as WITHDRAWALS_SUM from WITHDRAWALS where CARD_NUMBER = " + withdrawalRequest.getCardNumber() +" and WITHDRAWAL_DATE = CURRENT DATE");
            return rs.getDouble("WITHDRAWALS_SUM");
        } catch (SQLException e) {
            logger.error(ErrorMsgEnum.ERROR_IN_GET_WITHDRAWALS_SUM.toString());
            throw new WithdrawalException(ErrorMsgEnum.ERROR_IN_GET_WITHDRAWALS_SUM.toString());
        }
    }

    @Override
    public String addAmountForCustomerByCreditCard(WithdrawalRequest withdrawalRequest) throws WithdrawalException {
        return ErrorMsgEnum.WITHDRAWAL_CANCELED.toString();
    }

    @Override
    public String removeWithdrawalRecord(WithdrawalRequest withdrawalRequest) throws WithdrawalException{
        return ErrorMsgEnum.WITHDRAWAL_REMOVED.toString();
    }
}
