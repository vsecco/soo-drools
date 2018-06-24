package unesp.rc.creditloan.config;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {
    @Autowired(
            required = false
    )
    private TokenStore tokenStore;
    @Autowired(
            required = false
    )
    private DataSource dataSource;
    @Autowired(
            required = false
    )
    private AuthenticationManager authenticationManager;
    @Autowired(
            required = false
    )
    private UserDetailsService userDetailsService;
    @Autowired(
            required = false
    )
    private ClientDetailsService clientDetailsService;

    public AuthorizationServerConfigurer() {
    }

    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        if (this.clientDetailsService != null) {
            clients.withClientDetails(this.clientDetailsService);
        } else if (this.dataSource != null) {
            clients.jdbc(this.dataSource);
        }

    }

    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        if (this.tokenStore != null) {
            endpoints.tokenStore(this.tokenStore);
        } else if (this.dataSource != null) {
            TokenStore tokenStore = new JdbcTokenStore(this.dataSource);
            endpoints.tokenStore(tokenStore);
        }

        if (this.authenticationManager != null) {
            endpoints.authenticationManager(this.authenticationManager);
        }

        if (this.userDetailsService != null) {
            endpoints.userDetailsService(this.userDetailsService);
        }

    }
}
