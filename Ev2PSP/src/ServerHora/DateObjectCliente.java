package ServerHora;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import objetos.Persona;

public class DateObjectCliente {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Socket socket = new Socket("192.168.101.5", 3600);
		ObjectInputStream entradaObjeto = new ObjectInputStream(socket.getInputStream());

		Persona persona = (Persona) entradaObjeto.readObject();

		System.out.println(persona);

	}

}
