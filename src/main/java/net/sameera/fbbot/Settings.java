package net.sameera.fbbot;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "settings")
@Getter
@Setter
public class Settings {
    private String appVersion;
    private String greetMessage;
    private String customMessage;

}
