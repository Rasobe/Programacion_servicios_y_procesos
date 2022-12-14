package ServerHora;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class DateTextCliente {

	public static void main(String[] args) {
		try {
//			Sin timeout
//			Socket socket = new Socket("localhost", DateTextServer.PORT);
			
			
//			Preparo el socket
			Socket socket = new Socket();
//			Preparo la dirección del servidor. IP y Puerto
			SocketAddress sockAddr = new InetSocketAddress("localhost", DateTextServer.PORT);
//			Intento la conexión, estableciendo un timeout de 6 segundos			
			socket.connect(sockAddr, 6); 
			DataInputStream entrada = new DataInputStream(socket.getInputStream());
			System.out.println(entrada.readUTF());
			entrada.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
