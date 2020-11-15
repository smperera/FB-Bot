create table chat_message (
    message_id VARCHAR(50),
    message VARCHAR(100),
    received_time TIMESTAMP,
    sender_id VARCHAR(20),
    receiver_id VARCHAR(20),
    primary key (message_id)
);