package com.chatwebsocket.chat_web_socket.models.users;

import com.chatwebsocket.chat_web_socket.enums.UserRol;
import com.chatwebsocket.chat_web_socket.models.Mensaje;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Getter
    private Long Id;

    @Getter@Setter
    private String userName;
    @Getter@Setter
    private String password;
    @Getter@Setter
    private UserRol rol;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Mensaje> mensajes = new ArrayList<>();

    public Cliente(String userName, String password, UserRol rol) {
        this.userName = userName;
        this.password = password;
        this.rol = rol;
    }

    public Cliente() {

    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void addMensajes(Mensaje mensaje) {
        mensaje.setCliente(this);
        this.mensajes.add(mensaje);
    }
}
