package com.chatwebsocket.chat_web_socket.repositories;

import com.chatwebsocket.chat_web_socket.models.StorageMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageMessageRepository extends JpaRepository<StorageMessage, Long> {
}
