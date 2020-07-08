package com.fss.hystriximpl.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter
@EntityScan
@ToString
public class CustomerProfile {

    private String name;
    private String mailingAddr;
    private int age;
    private long mobileNum;


}
