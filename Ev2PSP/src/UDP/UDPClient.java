package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args) throws IOException {

		// Para construir esta conexion necesitamos el puerto y el objeto que
		// corresponde a nuestra direccion IP
		// no basta solo con ponerlo como string, por ello utilizamos el metodo
		// estatico .getByName de InetAddress
		DatagramSocket dSock = new DatagramSocket(3000, InetAddress.getByName("localhost"));

		// Hay que indicar una estimacion de lo que voy a recibir y la longitud, casi
		// siemppre coincidira el tamanyo.
		// (De alguna manera habrá que cuantificar esto en algun lado
		// para que no se escriba al tuntun, sino que tenga sentiido)
		byte[] arrayDeBytes = new byte[1000];
		DatagramPacket info = new DatagramPacket(arrayDeBytes, arrayDeBytes.length);
		dSock.receive(info);

		System.out.println("Recibido de: " + info.getAddress());
		System.out.println("Por el puerto: " + info.getPort());
		System.out.println("Datos recibidos: " + new String(info.getData(), "UTF-8"));

	}
}
