package com.chatwebsocket.chat_web_socket.models;

import com.chatwebsocket.chat_web_socket.models.users.Cliente;
import com.chatwebsocket.chat_web_socket.models.users.Vendedor;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Getter
    private Long Id;

    @Getter@Setter
    private String contenido;

    @ManyToOne(fetch = FetchType.EAGER)
    @Getter@Setter
    private StorageMessage storageMessage;

    @ManyToOne(fetch = FetchType.EAGER)
    @Getter@Setter
    private Vendedor vendedor;

    @ManyToOne(fetch = FetchType.EAGER)
    @Getter@Setter
    private Cliente cliente;

    public Mensaje(String contenido, Cliente cliente) {
        this.contenido = contenido;
        this.cliente = cliente;
    }

    public Mensaje(String contenido, Vendedor vendedor) {
        this.contenido = contenido;
        this.vendedor = vendedor;
    }
}
