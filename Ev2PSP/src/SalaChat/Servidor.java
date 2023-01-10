package SalaChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
	
	static final int PUERTO = 3000;
	
	public static void main(String[] args) {
		
		ArrayList<Mensaje> listaMensajes = new ArrayList<>();
		try {
			ServerSocket servSock = new ServerSocket(PUERTO);
			Socket sock = null;
			while (true) {
				sock = servSock.accept();
				new Emisor(sock, listaMensajes);
				new Receptor(sock, listaMensajes);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
