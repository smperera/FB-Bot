package net.sameera.abc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/abc")
public class ControllerA {

    @GetMapping(path = "/hello")
    public String hello() {
        return "Sameera";
    }
}