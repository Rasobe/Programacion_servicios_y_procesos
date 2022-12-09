package ServerHora;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class DateTextCliente {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", DateTextServer.PORT);
			DataInputStream entrada = new DataInputStream(socket.getInputStream());
			System.out.println(entrada.readUTF());
			entrada.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
