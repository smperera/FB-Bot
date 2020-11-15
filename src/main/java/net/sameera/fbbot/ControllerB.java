package net.sameera.fbbot;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/def")
@RequiredArgsConstructor
public class ControllerB {
    private final Settings settings;

    @GetMapping(path = "/hello")
    public String hello() {
        return settings.getGreetMessage() + ": " + settings.getAppVersion() + ": " + settings.getCustomMessage();
    }
}
