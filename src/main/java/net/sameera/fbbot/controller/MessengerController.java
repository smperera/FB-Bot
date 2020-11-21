package net.sameera.fbbot.controller;

import lombok.RequiredArgsConstructor;
import net.sameera.fbbot.service.FBMessageReader;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/facebook")
public class MessengerController {

    private final FBMessageReader fbMessageReader;

    @PostMapping(path = "/web-hook")
    public void saveMessage(@RequestBody String message) {
        fbMessageReader.readMessage(message);
    }

    @GetMapping(path = "/web-hook")
    public String verifyToken(@RequestParam Map<String, String> params) {
        return fbMessageReader.verify(params);
    }
}
