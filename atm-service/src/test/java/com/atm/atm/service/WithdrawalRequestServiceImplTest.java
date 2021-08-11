package com.atm.atm.service;

import com.atm.atm.ErrorMsgEnum;
import com.atm.atm.dao.WithdrawalsDao;
import com.atm.atm.entity.WithdrawalRequest;
import com.atm.atm.exception.WithdrawalException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
class WithdrawalRequestServiceImplTest {

    @MockBean
    private WithdrawalsDao withdrawalsDao;

    @Autowired
    private WithdrawalRequestService withdrawalRequestService;


    @Test
    void shouldReturnTrueWithdrawalDone() throws WithdrawalException {
        when(withdrawalsDao.getWithdrawalsCountByCreditCardAndSecretCode(any())).thenReturn(4);
        when(withdrawalsDao.getWithdrawalsSumByCreditCardAndSecretCode(any())).thenReturn(200d);
        assertEquals(withdrawalRequestService.withdrawalMoney(fillWithdrawalRequest()) , ErrorMsgEnum.WITHDRAWAL_DONE.toString());
    }

    @Test
    void shouldWithdrawalNotPassCountUpOfFive() throws WithdrawalException {
        when(withdrawalsDao.getWithdrawalsCountByCreditCardAndSecretCode(any())).thenReturn(7);
        when(withdrawalsDao.getWithdrawalsSumByCreditCardAndSecretCode(any())).thenReturn(200d);
        assertEquals(withdrawalRequestService.withdrawalMoney(fillWithdrawalRequest()) , ErrorMsgEnum.WITHDRAWAL_NOT_POSSIBLE.toString());
    }

    @Test
    void shouldWithdrawalNotPassSumUpOf2000() throws WithdrawalException {
        when(withdrawalsDao.getWithdrawalsCountByCreditCardAndSecretCode(any())).thenReturn(4);
        when(withdrawalsDao.getWithdrawalsSumByCreditCardAndSecretCode(any())).thenReturn(3000d);
        assertEquals(withdrawalRequestService.withdrawalMoney(fillWithdrawalRequest()), ErrorMsgEnum.WITHDRAWAL_NOT_POSSIBLE.toString());
    }

    private WithdrawalRequest fillWithdrawalRequest() {
        return new WithdrawalRequest("12340","1222",12d);
    }
}