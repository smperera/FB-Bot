package net.sameera.fbbot.repository;

import net.sameera.fbbot.models.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MessageRepositoryTest {
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void test1() {
        List<Message> messages = messageRepository.findAll();
        Assertions.assertEquals(2, messages.size());
    }
}