package net.sameera.fbbot;

import net.sameera.fbbot.config.FacebookSetting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = {
        "net.sameera.abc",
        "net.sameera.fbbot"
})
@EnableConfigurationProperties(value = {Settings.class, FacebookSetting.class})
public class FbBotApplication {
    public static void main(String[] args) {
        SpringApplication.run(FbBotApplication.class, args);
    }
}
