package com.fss.hystriximpl.serviceimpl;

import com.fss.hystriximpl.clients.AccountsServiceClient;
import com.fss.hystriximpl.domain.AccountDetails;
import com.fss.hystriximpl.dto.CustomerProfileDto;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class CustomerProfileServiceTest {

    @Autowired
    CustomerProfileServiceImpl customerProfileService;

    @Autowired
    AccountDetailsServiceImpl accountDetailsService;

    @Autowired
    AccountsServiceClient accountsServiceClient;

    @Test
    public void test_appendDetails() {
        CustomerProfileDto testDto =
                CustomerProfileDto.builder()
                        .age(25)
                        .mailingAddr("abc@gmail.com")
                        .mobileNum(6321456789L)
                        .name("cust1").build();

        String result = customerProfileService.appendDetails(testDto);

        assertEquals(testDto.getName() + testDto.getAge(), result);
    }

    @Test
    void test_getCustomerAccountDetails() {
        List<AccountDetails> accountDetails = customerProfileService.getCustomerAccountDetails();
        assertTrue(accountDetails.size() > 0);
    }

    @Test
    void test_getAccounts_exception() {
        Assertions.assertThrows(HystrixRuntimeException.class, () -> accountsServiceClient.getAccounts());
    }


}
