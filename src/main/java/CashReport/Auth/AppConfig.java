package CashReport.Auth;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class AppConfig extends AbstractSecurityWebApplicationInitializer {

    public AppConfig() {
        super(ApplicationSecurityConfig.class);
    }
}
