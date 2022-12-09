package ServerHora;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateTextServerMultiCliente {

	public static int PORT = 3500;

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(PORT);
			Socket socket;
			while (true) {
				socket = server.accept();
				DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
				Date fecha = new Date();
				salida.writeUTF(fecha.toString());
				salida.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
