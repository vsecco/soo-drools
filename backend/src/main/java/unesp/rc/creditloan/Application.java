package unesp.rc.creditloan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public TokenStore getTokenStore() {
        return new InMemoryTokenStore();
    }

    @Bean
    @Primary
    public ClientDetailsService getClientDetailsService() throws Exception {
        final ClientDetailsServiceBuilder builder = new ClientDetailsServiceBuilder().inMemory();
        builder
                .withClient("credit-loan")
                .secret("secret")
                .authorizedGrantTypes( "password")
                .scopes("read");

        return builder.build();
    }

}