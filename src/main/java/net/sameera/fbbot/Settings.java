package net.sameera.fbbot;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "settings")
public class Settings {
    private String appVersion;
    private String greetMessage;
    private String customMessage;

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getGreetMessage() {
        return greetMessage;
    }

    public void setGreetMessage(String greetMessage) {
        this.greetMessage = greetMessage;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }
}
