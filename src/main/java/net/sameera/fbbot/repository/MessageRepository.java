package net.sameera.fbbot.repository;

import net.sameera.fbbot.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, String> {
}
