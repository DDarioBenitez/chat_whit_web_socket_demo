package com.chatwebsocket.chat_web_socket.dto;

import com.chatwebsocket.chat_web_socket.models.StorageMessage;
import com.chatwebsocket.chat_web_socket.models.users.Vendedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
public class VendedorDTO {

    private long id;

    private String userName;

    public VendedorDTO(Vendedor vendedor){
        this.id = vendedor.getId();
        this.userName = vendedor.getUserName();
    }
}
