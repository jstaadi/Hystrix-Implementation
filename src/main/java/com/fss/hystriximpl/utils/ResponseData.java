package com.fss.hystriximpl.utils;

import com.fss.hystriximpl.exception.ErrorDetails;
import lombok.Data;

@Data
public class ResponseData<T> {
    private ErrorDetails status;
    private T data;
}
