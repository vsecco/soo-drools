package unesp.rc.creditloan.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(
        prefix = "oauth"
)
public class OAuthProperties {
    private String resourceId;
    private String test;
    private String[] allowedUrls;

    public OAuthProperties() {
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getTest() {
        return this.test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String[] getAllowedUrls() {
        return this.allowedUrls;
    }

    public void setAllowedUrls(String[] allowedUrls) {
        this.allowedUrls = allowedUrls;
    }
}
