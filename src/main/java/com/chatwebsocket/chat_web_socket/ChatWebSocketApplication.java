package com.chatwebsocket.chat_web_socket;

import com.chatwebsocket.chat_web_socket.enums.UserRol;
import com.chatwebsocket.chat_web_socket.models.users.Cliente;
import com.chatwebsocket.chat_web_socket.models.users.Vendedor;
import com.chatwebsocket.chat_web_socket.repositories.ClienteRepository;
import com.chatwebsocket.chat_web_socket.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChatWebSocketApplication {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private VendedorRepository vendedorRepository;



	public static void main(String[] args) {
		SpringApplication.run(ChatWebSocketApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(ClienteRepository clienteRepository, VendedorRepository vendedorRepository) {
		return args -> {
			Cliente cliente = new Cliente("Dario", "1234", UserRol.CLIENTE);
			clienteRepository.save(cliente);
			Vendedor vendedor = new Vendedor("DarioV", "1234", UserRol.VENDEDOR);
			vendedorRepository.save(vendedor);
		};
	}

}
