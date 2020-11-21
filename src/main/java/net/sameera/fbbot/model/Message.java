package net.sameera.fbbot.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "chat_message")
@Data
public class Message {
    @Id
    @Column(name = "message_id")
    private String messageId;

    @Column(name = "message")
    private String message;

    @Column(name = "received_time")
    private Date receivedTime;

    @Column(name = "sender_id")
    private String senderId;

    @Column(name = "receiver_id")
    private String receiverId;

}
