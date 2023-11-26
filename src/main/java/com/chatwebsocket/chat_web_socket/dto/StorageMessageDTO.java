package com.chatwebsocket.chat_web_socket.dto;

import com.chatwebsocket.chat_web_socket.models.StorageMessage;

import java.util.List;
import java.util.stream.Collectors;

public class StorageMessageDTO {

    private long id;
    private List<MensajeDTO> mensajes;
    private VendedorDTO vendedor;
    private ClienteDTO cliente;

    public StorageMessageDTO() {

    }
    public StorageMessageDTO(StorageMessage storageMessage) {
        this.id = storageMessage.getId();
        this.mensajes = storageMessage.getMensajes().stream().map(MensajeDTO::new).collect(Collectors.toList());
        this.vendedor = new VendedorDTO(storageMessage.getVendedor());
        this.cliente = new ClienteDTO(storageMessage.getCliente());
    }
}
