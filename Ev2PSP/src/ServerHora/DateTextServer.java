package ServerHora;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateTextServer {

	public static int PORT = 3500;

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(PORT);
			Socket socket = server.accept(); // server.accept() espera una señal de un socket
			DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
			Date fecha = new Date();
			salida.writeUTF(fecha.toString());
			salida.close();
			server.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
