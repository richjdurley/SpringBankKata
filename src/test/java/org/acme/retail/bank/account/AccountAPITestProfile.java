package org.acme.retail.bank.account;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.DirtiesContext;

@Profile("accountAPITestProfile")
@Configuration
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class AccountAPITestProfile {

    /** Mocked service example
    @Bean
    public AccountService mockedAccountService() {
        return Mockito.mock(AccountService.class);
    }**/

}
