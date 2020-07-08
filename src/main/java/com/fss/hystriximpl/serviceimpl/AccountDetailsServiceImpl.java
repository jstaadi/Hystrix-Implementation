package com.fss.hystriximpl.serviceimpl;

import com.fss.hystriximpl.domain.AccountDetails;
import com.fss.hystriximpl.service.AccountDetailsService;
import com.netflix.hystrix.HystrixInvokable;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * This servcie contains logic to communicate with AccountDetails microservice using WebClient
 *
 * @author just_aadi
 */
@Service
@Slf4j
public class AccountDetailsServiceImpl implements AccountDetailsService {

    /**
     * To store URL of account details microservice
     */
    private static final String ACCOUNT_DETAILS_URI = "http://localhost:8003/test/services/v1/getAccountDetails/";
    private static final String WEBCLIENT_HYSTRIX_ERROR = "AccountsDetailService#getDetails() failed and fallback disabled";
    private WebClient.Builder webClient = WebClient.builder();

    /**
     * This method has the implementation to communicate with other microservice
     * <p>
     * This method has a fallback method inside the class
     * {@link com.fss.hystriximpl.serviceimpl.AccountDetailsServiceImpl}
     *
     * @param accountId for which details has to be retrieved
     * @return the details object received from the response
     */
    @HystrixCommand(fallbackMethod = "getFallbackDetails")
    public AccountDetails getDetails(String accountId) {
        return webClient.build()
                .get()
                .uri(ACCOUNT_DETAILS_URI + accountId)
                .retrieve()
                .bodyToMono(AccountDetails.class)
                .block();
    }

    /**
     * This method has the implementation to return a default message as a fallback
     *
     * @param accountId for which details has to be retrieved
     * @return the hardcoded details object
     */
    private AccountDetails getFallbackDetails(String accountId) {
        throw new HystrixRuntimeException(HystrixRuntimeException.FailureType.COMMAND_EXCEPTION
                , HystrixInvokable.class
                , WEBCLIENT_HYSTRIX_ERROR
                , new RuntimeException(WEBCLIENT_HYSTRIX_ERROR)
                , new RuntimeException(WEBCLIENT_HYSTRIX_ERROR));
    }
}
