package com.fss.hystriximpl.clients;

import com.fss.hystriximpl.service.AccountsService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * This interface acts as a declarative for the feign client to communicate with Accounts microservice
 * <p>
 * Please see the {@link com.fss.hystriximpl.service.AccountsService} class for reference
 *
 * @author just_aadi
 */
@FeignClient(
        name = "accounts-proxy",
        url = "http://localhost:8002/test/services/v1")
public interface AccountsServiceClient extends AccountsService {

}
