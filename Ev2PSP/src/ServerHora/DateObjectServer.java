package ServerHora;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import objetos.Persona;

public class DateObjectServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(3600);
		Socket socket = server.accept();

		ObjectOutputStream salidaObjeto = new ObjectOutputStream(socket.getOutputStream());
		salidaObjeto.writeObject(new Persona("Pedro", 34));

		salidaObjeto.close();
		socket.close();
		server.close();
	}

}
