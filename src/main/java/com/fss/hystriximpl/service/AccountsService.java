package com.fss.hystriximpl.service;

import com.fss.hystriximpl.domain.Account;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface AccountsService {

    @GetMapping("/getAccounts/{userId}")
    public List<Account> getAccounts();

}
