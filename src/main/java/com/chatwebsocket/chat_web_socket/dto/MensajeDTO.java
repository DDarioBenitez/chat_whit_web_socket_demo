package com.chatwebsocket.chat_web_socket.dto;


import com.chatwebsocket.chat_web_socket.models.Mensaje;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor@AllArgsConstructor
@Getter
public class MensajeDTO {

    private String contenido;

    private VendedorDTO vendedor;

    private ClienteDTO cliente;

    public MensajeDTO(Mensaje mensaje){
        this.contenido = mensaje.getContenido();
        this.vendedor = new VendedorDTO(mensaje.getVendedor());
        this.cliente = new ClienteDTO(mensaje.getCliente());
    }

}
