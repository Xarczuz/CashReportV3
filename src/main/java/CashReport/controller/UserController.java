package CashReport.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    /**
     * Logout. This method is responsible for logout user from application based on
     * given accessToken.
     *
     * @param accessToken the access token
     * @return the response entity
     */
    @GetMapping(value = "/oauth/logout")
    public ResponseEntity<String> logout(@RequestParam(name = "access_token") String accessToken) {
        consumerTokenServices.revokeToken(accessToken);
        return new ResponseEntity<String>(HttpStatus.OK);

    }
}
