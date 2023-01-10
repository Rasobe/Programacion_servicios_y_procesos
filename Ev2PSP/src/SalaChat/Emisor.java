package SalaChat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Emisor extends Thread {

	private Socket sock;
	private ArrayList<Mensaje> listaMensajes;

	public Emisor(Socket sock, ArrayList<Mensaje> listaMensajes) {
		super();
		this.sock = sock;
		this.listaMensajes = listaMensajes;
	}

	@Override
	public void run() {
//		Inicializar la salida oos
//		while true
//			esperar notificacion (syncronizadamente)
//			coger el ultimo mensaje (syncronizadamente)
//			enviarlo
		
		ObjectInputStream oos = null;
		Mensaje m = null;
		try {
			oos = new ObjectInputStream(sock.getInputStream());
			while (true) {
				synchronized (listaMensajes) {
					listaMensajes.wait();
					m = (Mensaje) oos.readObject();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
