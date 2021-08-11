package com.atm.atm.controller;

import com.atm.atm.entity.WithdrawalRequest;
import com.atm.atm.service.CancelWithdrawalRequestService;
import com.atm.atm.service.WithdrawalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AtmController {

    @Autowired
    private WithdrawalRequestService withdrawalRequestService;

    @Autowired
    private CancelWithdrawalRequestService cancelWithdrawalRequestService;

    @PostMapping
    @RequestMapping("/withdrawalRequest")
    public String withdrawalMoney(WithdrawalRequest withdrawalRequest){
        return withdrawalRequestService.withdrawalMoney(withdrawalRequest);
    }

    @PostMapping
    @RequestMapping("/cancelWithdrawalRequest")
    public String cancelWithdrawalMoney(WithdrawalRequest withdrawalRequest){
        return cancelWithdrawalRequestService.cancelWithdrawalMoney(withdrawalRequest);
    }

}
