package com.fss.hystriximpl.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class JwtRequestDto {

    private String username;
    private String password;

}
