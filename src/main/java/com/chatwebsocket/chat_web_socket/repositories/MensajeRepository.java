package com.chatwebsocket.chat_web_socket.repositories;

import com.chatwebsocket.chat_web_socket.models.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
}
