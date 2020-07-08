package com.fss.hystriximpl.utils;

import com.fss.hystriximpl.constants.ErrorConstants;
import com.fss.hystriximpl.exception.ErrorDetails;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class ResponseBuilder {


    public <T> ResponseEntity<ResponseData<T>> invokeService(Supplier<T> responseSupplier) {
        T data = responseSupplier.get();

        ResponseData<T> resp = new ResponseData<>();
        resp.setData(data);
        resp.setStatus(ErrorDetails.builder()
                .code(ErrorConstants.RESPONSE_CODE)
                .message(ErrorConstants.RESPONSE_MESSSAGE)
                .timestamp(LocalDateTime.now())
                .build());

        return ResponseEntity.ok(resp);
    }


}
