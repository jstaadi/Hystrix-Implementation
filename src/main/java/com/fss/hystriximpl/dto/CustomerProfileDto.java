package com.fss.hystriximpl.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CustomerProfileDto {
    private String name;
    private String mailingAddr;
    private Integer age;
    private Long mobileNum;

}
