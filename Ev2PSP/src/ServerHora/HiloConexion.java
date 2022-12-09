package ServerHora;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class HiloConexion extends Thread {

	Socket socket;
	int contador = 0;
	
	public HiloConexion(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		DataOutputStream salida;
		try {
			salida = new DataOutputStream(socket.getOutputStream());			
			Date fecha = new Date();
			contador++;
			salida.writeUTF(fecha.toString());
			salida.writeInt(contador);
			salida.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
