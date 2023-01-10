package SalaChat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {

		try {
			Socket sock = new Socket("192.168.101.100", Servidor.PUERTO);
			new TecladoEnviar(sock).start();
			ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
			while (true) {
				System.out.println((Mensaje) ois.readObject());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
