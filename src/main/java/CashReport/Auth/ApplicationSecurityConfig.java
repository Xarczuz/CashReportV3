package CashReport.Auth;

import CashReport.config.CorsFilter;
import CashReport.repository.UserRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.Cookie;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserRepo userRepo;

    public ApplicationSecurityConfig(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(userRepo);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();//new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
    }

    @Bean
    CorsFilter corsFilter() {
        CorsFilter filter = new CorsFilter();
        return filter;
    }

    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("Im configuring it");
        (
                        (
                                (HttpSecurity)
                                        (
                                                (ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)
                                                        http
                                                                .headers().addHeaderWriter(
                                                                new StaticHeadersWriter("Access-Control-Allow-Origin", "*")).and()
                                                                .addFilterBefore(corsFilter(), SessionManagementFilter.class).csrf().disable()
                                                                .authorizeRequests()
                                                                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                                                                .anyRequest()
                                        ).authenticated().and()
                        ).formLogin().successHandler(successHandler()).and()
        ).logout().logoutUrl("/logout").logoutSuccessUrl("/login").deleteCookies("role", "JSESSIONID").invalidateHttpSession(true).permitAll();
    }
//            .logout().logoutUrl("/logout").logoutSuccessUrl("/login").deleteCookies("auth_code").invalidateHttpSession(true)
    private AuthenticationSuccessHandler successHandler() {
        return (httpServletRequest, httpServletResponse, authentication) -> {
            StringBuilder stringBuilder = new StringBuilder();
            authentication.getAuthorities().forEach(o -> stringBuilder.append(o.getAuthority()));
            httpServletResponse.getWriter().append("OK");
            httpServletResponse.setStatus(200);
            httpServletResponse.addCookie(new Cookie("role", stringBuilder.toString()));
        };
    }
}

//public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final PasswordEncoder passwordEncoder;
//    private final ApplicationUserService applicationUserService;
//
//    @Autowired
//    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,
//                                     ApplicationUserService applicationUserService) {
//        this.passwordEncoder = passwordEncoder;
//        this.applicationUserService = applicationUserService;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
//                .antMatchers("/api/**").hasRole(STUDENT.name())
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                    .loginPage("/login")
//                    .permitAll()
//                    .defaultSuccessUrl("/courses", true)
//                    .passwordParameter("password")
//                    .usernameParameter("username")
//                .and()
//                .rememberMe()
//                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
//                    .key("somethingverysecured")
//                    .rememberMeParameter("remember-me")
//                .and()
//                .logout()
//                    .logoutUrl("/logout")
//                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")) // https://docs.spring.io/spring-security/site/docs/4.2.12.RELEASE/apidocs/org/springframework/security/config/annotation/web/configurers/LogoutConfigurer.html
//                    .clearAuthentication(true)
//                    .invalidateHttpSession(true)
//                    .deleteCookies("JSESSIONID", "remember-me")
//                    .logoutSuccessUrl("/login");
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(passwordEncoder);
//        provider.setUserDetailsService(applicationUserService);
//        return provider;
//    }
//
//}
