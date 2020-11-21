package net.sameera.fbbot;

import lombok.RequiredArgsConstructor;
import net.sameera.fbbot.model.Message;
import net.sameera.fbbot.repository.MessageRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/def")
@RequiredArgsConstructor
public class ControllerB {
    private final Settings settings;
    private final MessageRepository messageRepository;

    @GetMapping(path = "/hello")
    public String hello() {
        return settings.getGreetMessage() + ": " + settings.getAppVersion() + ": " + settings.getCustomMessage();
    }

    @GetMapping(path = "/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> messages() {
        return messageRepository.findAll();
    }

    @PostMapping(path = "/messages", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> sendMessage(@RequestBody Message message){
        message.setMessageId(UUID.randomUUID().toString());
        message.setReceivedTime(new Date());
        messageRepository.save(message);
        return messageRepository.findAll();
    }
}
