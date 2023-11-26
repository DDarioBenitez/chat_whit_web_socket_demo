package com.chatwebsocket.chat_web_socket.dto;

import com.chatwebsocket.chat_web_socket.models.users.Cliente;
import lombok.Getter;

@Getter
public class ClienteDTO {

    private long id;
    private String userName;

    public ClienteDTO(long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.userName = cliente.getUserName();
    }

    public  ClienteDTO() {

    }

}
