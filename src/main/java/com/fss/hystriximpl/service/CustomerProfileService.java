package com.fss.hystriximpl.service;

import com.fss.hystriximpl.domain.AccountDetails;
import com.fss.hystriximpl.dto.CustomerProfileDto;

import java.util.List;

public interface CustomerProfileService {

    public String getAllCustomerProfile();

    public String appendDetails(CustomerProfileDto testDto);

    public List<AccountDetails> getCustomerAccountDetails();

}
