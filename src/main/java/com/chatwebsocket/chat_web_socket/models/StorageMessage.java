package com.chatwebsocket.chat_web_socket.models;

import com.chatwebsocket.chat_web_socket.models.users.Cliente;
import com.chatwebsocket.chat_web_socket.models.users.Vendedor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class StorageMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Getter
    private Long Id;

    @OneToMany(mappedBy = "storageMessage")
    private List<Mensaje> mensajes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @Getter@Setter
    private Vendedor vendedor;

    @ManyToOne(fetch = FetchType.EAGER)
    @Getter@Setter
    private Cliente cliente;

    public StorageMessage(Vendedor vendedor, Cliente cliente) {
        this.vendedor = vendedor;
        this.cliente = cliente;
    }

    public StorageMessage() {

    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void addMensajes(Mensaje mensaje) {
        mensaje.setStorageMessage(this);
        this.mensajes.add(mensaje);
    }
}
