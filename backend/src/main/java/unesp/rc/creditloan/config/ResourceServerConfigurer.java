package unesp.rc.creditloan.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(
        prePostEnabled = true
)

public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {
    @Autowired
    OAuthProperties oAuthProperties;
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
    private UserDetailsService userDetailsService;

    public ResourceServerConfigurer() {
    }

    public void configure(ResourceServerSecurityConfigurer resources) {
        if (this.tokenStore != null) {
            resources.tokenStore(this.tokenStore);
        } else if (this.dataSource != null) {
            TokenStore tokenStore = new JdbcTokenStore(this.dataSource);
            resources.tokenStore(tokenStore);
        }

        String resourceId = this.oAuthProperties.getResourceId();
        if (resourceId != null && !resourceId.isEmpty()) {
            resources.resourceId(resourceId);
        }

    }

    public void configure(HttpSecurity http) throws Exception {
        if (this.userDetailsService != null) {
            http.userDetailsService(this.userDetailsService);
        }

        if (this.oAuthProperties.getAllowedUrls() == null) {
            ((AuthorizedUrl)((AuthorizedUrl)http.authorizeRequests().antMatchers(new String[]{"/public/**"})).permitAll().anyRequest()).authenticated();
        } else {
            ((AuthorizedUrl)((AuthorizedUrl)http.authorizeRequests().antMatchers(this.oAuthProperties.getAllowedUrls())).permitAll().anyRequest()).authenticated();
        }

    }
}
