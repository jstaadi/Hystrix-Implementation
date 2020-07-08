package com.fss.hystriximpl.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This model is to represent the response from AccountDetails microservice
 *
 * @author just_aadi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetails {
    /**
     * Id of the account
     */
    private String accountId;
    /**
     * Name of the account
     */
    private String accountName;
    /**
     * Type of the account
     */
    private String accountType;
    /**
     * Balance in the account
     */
    private String accountBal;
}
