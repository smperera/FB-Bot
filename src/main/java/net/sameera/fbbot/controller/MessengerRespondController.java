package net.sameera.fbbot.controller;

import lombok.RequiredArgsConstructor;
import net.sameera.fbbot.model.Message;
import net.sameera.fbbot.service.FBMessageReader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/facebook-responder")
@RequiredArgsConstructor
public class MessengerRespondController {
    private final FBMessageReader fbMessageReader;

    @PostMapping(path = "/respond")
    public Message sendMessage(@RequestBody Message message) {
        return fbMessageReader.send(message);
    }
}
