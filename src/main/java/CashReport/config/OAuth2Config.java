package CashReport.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    private String clientid = "perham";
    private String clientSecret = "1234";
    private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEpAIBAAKCAQEA2iPAA1qUj4ez7CWQtk6exYQsDdANRowDG3PjjkLZ04TZT7hI\n" +
            "3bbFV4LO4IiB1EVVo1Nj1xPNb6xBH1Gy5z6clqsaJ+fTBq7JrKVZWZPAVxE+i2lK\n" +
            "qRv3z9tmyGKJO9bLTl08RfYGVRGil/Rl5a/irdCTufe/r3K5QKTNb7mc4tNETOnC\n" +
            "eblHuxh5P1bKuElgoNSUkvHlceFYIoT6lvnOLz5WYpJn9AODVdvkTUtAcIWIYR5p\n" +
            "v+G5IAWz1mVbETEniDHBvzPSUA+Lwv/4oWBeK7hkCkkQbEKy2VhAIYx+hf+3iDA/\n" +
            "D7eyH2ZWOBb0VoVpRHNMwIZ49eXkkypMOAJ+6QIDAQABAoIBAQCCmabLGz8Yk7GH\n" +
            "75GtZHKwZIqPloFsPEVb+U1DDgkmF0KX9QhDHbsWwq0jRvcb5Ir6JuH+kc+MTYAL\n" +
            "xTksM5NCrZwSSjxQovMBl1lgRRKBzkQ46UgW6TS70GrADCaHmfjMqQt+A2cVJWLI\n" +
            "QT2Ef4JieB8J1yd/XltFNaX9fw5Lyf97UqwFbNXHzCybzoMghyJz7oRlftnfNVkV\n" +
            "7449h37bWeI00mgrH9Y1nAdqPAKfVVTnG7th/GKiadVl1KjLmvuZAaTn6gQfc+B/\n" +
            "jc74C6Tudam10JMRsdmZbez8pNtszbQxS05WYsdB6NhLuQ9/7RWrbnWfJPhOroRT\n" +
            "Lj6e93elAoGBAPsvHESh09q9S9PIKRv1dAqeXxrkVoo2G/4yjEQvP52p+ADSWXhu\n" +
            "9VIZF5+/npP7GGuj9WvrfTxRwe9ph8mnwCQ/8GPMdyf5HWOW6qRTSNod98VcBE/W\n" +
            "ZVEIUesJwRQLNeWS3mgeHvbkmds+ZkToH9appSKVS3q/Dd49NVBnZFSPAoGBAN5S\n" +
            "cpCFsGMaTGspw9fpGPmhIkD3A32kn7xlZPwUS1fTLay4DNmWbGqT8DdipkSAmKys\n" +
            "CSsmfcJbkybL8IEhszO7oCylUXzpz7bzVpBdFL/m4Dd3n9jz1kZpdxXVq5bVyLlc\n" +
            "cSPMGzkHm3Kgep9IhmgHftBgGcss+uKGZ2J9JmEHAoGBAIAAOOKMqP4+GscYqEJU\n" +
            "KcdDf2mf1K3n9wnpzmrsvPlmZThd+TQTLzagDNbeejwk6APqcKWHQrGbZD3RxF2x\n" +
            "+4s9fg4NYude3mgivv3wZx6nyNytEJFyyvypRb2FofvJ3rRXzLi4KMVeJz1/pfQV\n" +
            "aiwlFT7zX5x0geevv1xy48DnAoGAW5URFpHL4Hcz5a01vNqL7EFBcAuRR4+qMZx/\n" +
            "JgxiIRKgLRdAS93YWWsJuHcN0Qg8XF0eBcV8ZrT8gC3grAEq5fOzftC3KcLTSyUg\n" +
            "kqWVZ5v+3zqLAX8o1KabZMY5QhBc+GapQLrSuAJ3OZf8C2N/4pi717DOz1B/JROC\n" +
            "wSKWzb8CgYAy9SqZKT9fG9C296ObU9b2tIRU8QOhRJMkddSsFWX7Tcqps+ZpSz9W\n" +
            "ysMpaEfg1+FZAv3aeM5kZ/M8Bfrf9Fd2pDTXzNgoh9tcWYvnBmxci1dQidelSVQ6\n" +
            "BtuElijuBJOfaRMPsGjPMr+QO150FJSDC97pEP5RHEFmeHClG5AIRA==\n" +
            "-----END RSA PRIVATE KEY-----\n";
    private String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2iPAA1qUj4ez7CWQtk6e\n" +
            "xYQsDdANRowDG3PjjkLZ04TZT7hI3bbFV4LO4IiB1EVVo1Nj1xPNb6xBH1Gy5z6c\n" +
            "lqsaJ+fTBq7JrKVZWZPAVxE+i2lKqRv3z9tmyGKJO9bLTl08RfYGVRGil/Rl5a/i\n" +
            "rdCTufe/r3K5QKTNb7mc4tNETOnCeblHuxh5P1bKuElgoNSUkvHlceFYIoT6lvnO\n" +
            "Lz5WYpJn9AODVdvkTUtAcIWIYR5pv+G5IAWz1mVbETEniDHBvzPSUA+Lwv/4oWBe\n" +
            "K7hkCkkQbEKy2VhAIYx+hf+3iDA/D7eyH2ZWOBb0VoVpRHNMwIZ49eXkkypMOAJ+\n" +
            "6QIDAQAB\n" +
            "-----END PUBLIC KEY-----\n";


    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Bean
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(privateKey);
        converter.setVerifierKey(publicKey);
        return converter;
    }
    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(tokenEnhancer());
    }
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
                .accessTokenConverter(tokenEnhancer());
    }
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        System.out.println("Kommer jag hit, daniel");
        clients.inMemory().withClient(clientid).secret(clientSecret).scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
                .refreshTokenValiditySeconds(20000);


    }
}