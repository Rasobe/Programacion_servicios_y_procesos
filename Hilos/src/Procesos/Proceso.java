package Procesos;

import java.io.IOException;

public class Proceso {
	
	public static void main(String[] args) throws IOException {
		
		Process proc = new ProcessBuilder("/usr/bin/firefox", "https://educa.aragon.es").start();
	}

}
