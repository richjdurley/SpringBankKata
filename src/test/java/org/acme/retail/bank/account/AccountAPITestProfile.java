package org.acme.retail.bank.account;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.DirtiesContext;

@Profile("accountAPITestProfile")
@Configuration
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class AccountAPITestProfile {

    @Bean
    public IdentityService mockedIdentityService() {
        return Mockito.mock(IdentityService.class);
    }

    @Bean
    @Primary
    public AccountService mockedAccountService() {
        return Mockito.spy(AccountService.class);
    }

}

