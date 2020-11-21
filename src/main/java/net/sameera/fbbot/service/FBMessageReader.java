package net.sameera.fbbot.service;

import com.github.messenger4j.Messenger;
import com.github.messenger4j.exception.MessengerApiException;
import com.github.messenger4j.exception.MessengerIOException;
import com.github.messenger4j.exception.MessengerVerificationException;
import com.github.messenger4j.send.MessagePayload;
import com.github.messenger4j.send.MessagingType;
import com.github.messenger4j.send.message.TextMessage;
import net.sameera.fbbot.config.FacebookSetting;
import net.sameera.fbbot.repository.MessageRepository;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class FBMessageReader {
    private final MessageRepository messageRepository;
    private final FacebookSetting facebookSetting;


    final Messenger messenger;

    public FBMessageReader(MessageRepository messageRepository, FacebookSetting facebookSetting) {
        this.messageRepository = messageRepository;
        this.facebookSetting = facebookSetting;
        messenger = Messenger.create(facebookSetting.getAccessToken(), facebookSetting.getAppSecret(), facebookSetting.getVerifyToken());
    }

    public void readMessage(String message) {
        System.out.println("Received msg: " + message);

        try {
            messenger.onReceiveEvents(
                    message,
                    Optional.empty(),
                    event -> {
                        final String senderId = event.senderId();
                        if (event.isTextMessageEvent()) {
                            final String text = event.asTextMessageEvent().text();
                            System.out.println("##### " + text);

                            final TextMessage textMessage = TextMessage.create(text);
                            final MessagePayload messagePayload =
                                    MessagePayload.create(senderId, MessagingType.RESPONSE, textMessage);

                            try {
                                messenger.send(messagePayload);
                            } catch (MessengerApiException | MessengerIOException e) {
                                // Oops, something went wrong
                            }
                        }
                    });
        }
        catch (MessengerVerificationException exception) {

        }
    }

    public String verify(Map<String, String> params) {
        params.keySet().stream().forEach(key -> System.out.println(key + ": " + params.get(key)));
        try {
            messenger.verifyWebhook(params.get("hub.mode"), facebookSetting.getVerifyToken());
        }
        catch (MessengerVerificationException messengerVerificationException) {

        }

        return params.get("hub.challenge");
    }
}
