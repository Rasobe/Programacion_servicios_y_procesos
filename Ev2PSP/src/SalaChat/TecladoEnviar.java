package SalaChat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TecladoEnviar extends Thread {

	Socket sock;

	public TecladoEnviar(Socket sock) {
		super();
		this.sock = sock;
	}

	@Override
	public void run() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escribe tu nombre y pulsa enter:");
		String nombre = teclado.nextLine();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(sock.getOutputStream());
			while (true) {
				oos.writeObject(new Mensaje(nombre, teclado.nextLine()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
