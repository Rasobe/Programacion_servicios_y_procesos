package ServerHora;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DateTextServerMultiClienteSimultaneo {

	public static int PORT = 3500;

	public static void main(String[] args) throws IOException {

			ServerSocket server = new ServerSocket(PORT);
			Socket socket;
			while (true) {
				socket = server.accept();
				new HiloConexion(socket).start();
			}

	}

}
