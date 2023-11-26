let stompClient = null;

const vendedorId = '1'; // Obtener el ID del vendedor
const clienteId = '1'; // Obtener el ID del cliente o manejarlo según tu lógica

const onConnectSocket = () => {
    console.log('Socket conectado');
    // No suscribirse directamente aquí, se suscribirá cuando obtengamos el ID de la sala
}

const onCloseSocket = () => {
    if (stompClient !== null) {
        stompClient.deactivate();
    }
}

const connectarWS = (salaId) => {
    stompClient = new StompJs.Client({
        webSocketFactory: () => new WebSocket('ws://localhost:8080/chat'),
    });
    stompClient.onConnect = () => {
        console.log('Socket conectado');
        stompClient.subscribe(`/sala-privada/${salaId}`, (message) => {
            console.log(message.body);
            mostrarMensaje(message.body);
        });
    };
    stompClient.onWebSocketClose = onCloseSocket;
    stompClient.activate();
}

const enviarMensaje = () => {
    let txtNombre = document.getElementById('txtNombre');
    let txtContenido = document.getElementById('txtMensaje');

    stompClient.publish({
        destination: '/app/private-message/cliente/1-1/1',
        body: JSON.stringify({
            nombre: txtNombre.value,
            contenido: txtContenido.value
        })
    })
}

const mostrarMensaje = (mensaje) => {
    const body = JSON.parse(mensaje)
    console.log(body.body);
    const ULMensajes = document.getElementById('ULMensajes')

    const mensajeLI = document.createElement('li')
    mensajeLI.classList.add('list-group-item')
    mensajeLI.innerHTML = `<strong>${body.body.nombre}</strong>: ${body.body.contenido}`
    ULMensajes.appendChild(mensajeLI)
}

const crearSalaConversacion = (vendedorId, clienteId) => {
    const endpoint = `/api/salas/crear-sala/${vendedorId}/${clienteId}`;

    fetch(endpoint, {
        method: 'POST',
        // ... otras configuraciones ...
    })
        .then(response => response.json())
        .then(data => {
            console.log(data);
            const salaId = data.salaId; // Asegúrate de obtener el ID de la sala correcto desde la respuesta JSON
            connectarWS(salaId);
        })
        .catch(error => {
            console.error('Error al crear la sala:', error);
        });
}

document.addEventListener('DOMContentLoaded', function () {
    const btnEnviar = document.getElementById('btnEnviar');
    btnEnviar.addEventListener('click', (e) => {
        e.preventDefault();
        enviarMensaje();
    })
    crearSalaConversacion(vendedorId, clienteId); // Llama a crearSalaConversacion para obtener el ID de la sala
})
