package com.chatwebsocket.chat_web_socket.controllers;


import com.chatwebsocket.chat_web_socket.dto.SalaDTO;
import com.chatwebsocket.chat_web_socket.repositories.StorageMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/salas")
public class SalasController {

    @Autowired
    private StorageMessageRepository storageMessageRepository;

    @PostMapping("/crear-sala/{vendedorId}/{clienteId}")
    public ResponseEntity<Object> crearSalaPrivada(@PathVariable String vendedorId, @PathVariable String clienteId) {
        String salaId = generarSalaId(vendedorId, clienteId);
        return new ResponseEntity<>(new SalaDTO(salaId), HttpStatus.OK);
    }

    private String generarSalaId(String vendedorId, String clienteId) {
        // Lógica para generar un identificador único para la sala privada
        return vendedorId + "-" + clienteId; // Puedes utilizar otro enfoque para generar IDs únicos
    }
}
