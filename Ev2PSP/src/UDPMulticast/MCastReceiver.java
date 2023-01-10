package UDPMulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class MCastReceiver {

	public static void main(String[] args) throws IOException {
		
		MulticastSocket mCastSocket = new MulticastSocket(3000);
		InetAddress ipGrupo = InetAddress.getByName("224.0.0.1");
		mCastSocket.joinGroup(ipGrupo);
		mCastSocket.setNetworkInterface(NetworkInterface.getByName("Ethernet 2"));
		
//		while(true) {
		byte[] arrayDeBytes = new byte[1000];
		DatagramPacket info = new DatagramPacket(arrayDeBytes, arrayDeBytes.length);
		
		mCastSocket.receive(info);
		
		System.out.println("Recibido de: " + info.getAddress());
		System.out.println("Por el puerto: " + info.getPort());
		System.out.println("Datos recibidos: " + new String(info.getData(), "UTF-8"));
//		}
	}
	
}
