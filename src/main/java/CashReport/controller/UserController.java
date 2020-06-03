package CashReport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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
        return ResponseEntity.status(HttpStatus.OK).body("LOGOUT");

    }
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, String> currentUserName(Authentication authentication) {
        HashMap<String, String> userDetails = new HashMap<>();
        String role = authentication.getAuthorities().stream().findFirst().get().toString();
        userDetails.put("ROLE", role.substring(5));
        userDetails.put("USER", authentication.getPrincipal().toString());
        return userDetails;
    }
}
