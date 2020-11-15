package net.sameera.fbbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/def")
public class ControllerB {
    @Autowired
    private Settings settings;

    @GetMapping(path = "/hello")
    public String hello() {
        return settings.getGreetMessage() + ": " + settings.getAppVersion() + ": " + settings.getCustomMessage();
    }
}
