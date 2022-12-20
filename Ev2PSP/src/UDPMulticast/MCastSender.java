package UDPMulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MCastSender {

	public static void main(String[] args) throws IOException {
		
		DatagramSocket socket = new DatagramSocket();
		
		InetAddress ipGrupo = InetAddress.getByName("224.0.0.1");
		
		String mensaje = "Los reguetoneroh dan miedo";
		
		// le pasamos los bytes, su longitud, la ip y el puerto con el que nos vamos a conectar
		DatagramPacket info = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, ipGrupo, 3000);
		
		socket.send(info);
		socket.close();
		
	}
	
}
