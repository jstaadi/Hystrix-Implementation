package com.fss.hystriximpl.rest.controller;

import com.fss.hystriximpl.dto.CustomerProfileDto;
import com.fss.hystriximpl.service.CustomerProfileService;
import com.fss.hystriximpl.utils.ResponseBuilder;
import com.fss.hystriximpl.utils.ResponseData;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(value = "Customer Profile API")
public class CustomerProfileController extends ResponseBuilder {

    @Autowired
    CustomerProfileService testService;

    @Autowired
    ResponseBuilder responseBuilder;

    @GetMapping("/customerProfile")
    public ResponseEntity<ResponseData<Object>> getAllCustomerProfile() {
        log.info("Get the customer profile details");
        return invokeService(() -> testService.getAllCustomerProfile());
    }

    @PostMapping("/saveCustomerProfile")
    public ResponseEntity<ResponseData<Object>> appendDetails(@RequestBody CustomerProfileDto customerProfileDto) {
        log.info("Entered into Customer data Details");
        return invokeService(() -> testService.appendDetails(customerProfileDto));
    }

    @GetMapping("/customerProfile/getAccountDetails")
    public ResponseEntity<ResponseData<Object>> getCustomerAccountDetails() {
        log.info("Get the customer profile details");
        return invokeService(() -> testService.getCustomerAccountDetails());
    }


}
