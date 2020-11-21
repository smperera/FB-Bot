package net.sameera.fbbot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fb-settings")
@Getter
@Setter
public class FacebookSetting {
    private String accessToken;
    private String appSecret;
    private String verifyToken;
}
