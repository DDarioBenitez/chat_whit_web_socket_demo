package com.chatwebsocket.chat_web_socket.controllers;

import com.chatwebsocket.chat_web_socket.dto.MensajeDTO;
import com.chatwebsocket.chat_web_socket.dto.MensajePruebaDTO;
import com.chatwebsocket.chat_web_socket.dto.SalaDTO;
import com.chatwebsocket.chat_web_socket.models.Mensaje;
import com.chatwebsocket.chat_web_socket.models.users.Cliente;
import com.chatwebsocket.chat_web_socket.models.users.Vendedor;
import com.chatwebsocket.chat_web_socket.repositories.ClienteRepository;
import com.chatwebsocket.chat_web_socket.repositories.MensajeRepository;
import com.chatwebsocket.chat_web_socket.repositories.StorageMessageRepository;
import com.chatwebsocket.chat_web_socket.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChatController {

    @Autowired
    private MensajeRepository mensajeRepository;
    @Autowired
    private VendedorRepository vendedorRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private StorageMessageRepository storageMessageRepository;


    @MessageMapping("/private-message/cliente/{salaId}/{clienteId}")
    @SendTo("/sala-privada/{salaId}")
    public ResponseEntity<Object> enviarMensajeCliente(@DestinationVariable String salaId, @DestinationVariable Long clienteId, MensajePruebaDTO mensajeDTO) {
        // Lógica para enviar un mensaje a una sala privada
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
        Mensaje mensaje = new Mensaje(mensajeDTO.getContenido(),cliente);
        assert cliente != null;
        cliente.addMensajes(mensaje);
        clienteRepository.save(cliente);
        mensajeRepository.save(mensaje);
        return new ResponseEntity<>(new MensajePruebaDTO(mensajeDTO.getNombre(), mensajeDTO.getContenido()), HttpStatus.OK);
    }

    @MessageMapping("/private-message/vendedor/{salaId}/{vendedorId}")
    @SendTo("/sala-privada/{salaId}")
    public ResponseEntity<Object> enviarMensajeVendedor(@DestinationVariable String salaId, @PathVariable Long vendedorId, MensajeDTO mensajeDTO) {
        // Lógica para enviar un mensaje a una sala privada
        Vendedor vendedor = vendedorRepository.findById(vendedorId).orElse(null);
        Mensaje mensaje = new Mensaje(mensajeDTO.getContenido(),vendedor);
        assert vendedor != null;
        vendedor.addMensajes(mensaje);
        vendedorRepository.save(vendedor);
        mensajeRepository.save(mensaje);
        return new ResponseEntity<>(new SalaDTO(salaId), HttpStatus.OK);
    }
}
