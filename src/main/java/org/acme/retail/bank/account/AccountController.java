package org.acme.retail.bank.account;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController()
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IdentityService identityService;

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public String register(@RequestHeader("Authorization-X") String authorizationHeader, @RequestBody AccountRequest request) {
        if (!identityService.verifyToken(authorizationHeader)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        return accountService.register(request);
    }
}
