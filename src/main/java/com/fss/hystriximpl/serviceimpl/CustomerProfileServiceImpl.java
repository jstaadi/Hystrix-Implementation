package com.fss.hystriximpl.serviceimpl;

import com.fss.hystriximpl.clients.AccountsServiceClient;
import com.fss.hystriximpl.domain.Account;
import com.fss.hystriximpl.domain.AccountDetails;
import com.fss.hystriximpl.domain.CustomerProfile;
import com.fss.hystriximpl.dto.CustomerProfileDto;
import com.fss.hystriximpl.service.AccountDetailsService;
import com.fss.hystriximpl.service.CustomerProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableFeignClients(basePackageClasses = AccountsServiceClient.class)
public class CustomerProfileServiceImpl implements CustomerProfileService {

    @Autowired
    private AccountDetailsService accountDetailsService;

    @Autowired
    private AccountsServiceClient accountsService;

    @Override
    public String appendDetails(CustomerProfileDto testDto) {
        ModelMapper mm = new ModelMapper();
        CustomerProfile test = mm.map(testDto, CustomerProfile.class);
        return test.getName() + test.getAge();
    }

    @Override
    public List<AccountDetails> getCustomerAccountDetails() {
        List<Account> accounts = accountsService.getAccounts();
        return accounts.stream().map(account -> accountDetailsService.getDetails(account.getAccountId())).collect(Collectors.toList());

    }

    @Override
    public String getAllCustomerProfile() {
        return "Welcome to get details method";
    }

}
