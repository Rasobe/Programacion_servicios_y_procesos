package SalaChat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Receptor extends Thread {

	private Socket sock;
	private ArrayList<Mensaje> listaMensajes;

	public Receptor(Socket sock, ArrayList<Mensaje> listaMensajes) {
		super();
		this.sock = sock;
		this.listaMensajes = listaMensajes;
	}

	@Override
	public void run() {
		ObjectInputStream ois = null;
		Mensaje m = null;
		try {
			ois = new ObjectInputStream(sock.getInputStream());
			while (true) {
				m = (Mensaje) ois.readObject();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		synchronized (listaMensajes) {
			listaMensajes.add(m);
			listaMensajes.notifyAll();
		}
	}

}
