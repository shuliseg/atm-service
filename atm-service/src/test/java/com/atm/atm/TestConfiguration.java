package com.atm.atm;

import com.atm.atm.dao.WithdrawalsDao;
import com.atm.atm.dao.WithdrawalsDaoImpl;
import com.atm.atm.service.WithdrawalRequestService;
import com.atm.atm.service.WithdrawalRequestServiceImpl;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfiguration {
    @Bean
    @Primary
    public WithdrawalRequestService withdrawalRequestService(){
return Mockito.mock(WithdrawalRequestServiceImpl.class);
    }

    @Bean
    @Primary
    public WithdrawalsDao withdrawalsDao(){
        return Mockito.mock(WithdrawalsDao.class);
    }
}
