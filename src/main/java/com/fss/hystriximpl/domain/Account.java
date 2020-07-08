package com.fss.hystriximpl.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This model is to represent the response from Accounts microservice
 *
 * @author just_aadi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    /**
     * Id of the account
     */
    private String accountId;
    /**
     * Name of the account
     */
    private String accountName;
}
