package com.chatwebsocket.chat_web_socket.repositories;

import com.chatwebsocket.chat_web_socket.models.users.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
