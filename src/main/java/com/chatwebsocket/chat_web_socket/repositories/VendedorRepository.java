package com.chatwebsocket.chat_web_socket.repositories;

import com.chatwebsocket.chat_web_socket.models.users.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}
