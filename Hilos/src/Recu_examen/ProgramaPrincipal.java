package Recu_examen;

import java.util.ArrayList;

public class ProgramaPrincipal {

	public static void main(String[] args) throws InterruptedException {
		
		ResultadoSorteo rs = new ResultadoSorteo();
		ArrayList<Participante> listaParticipantes = new ArrayList<>();
		
		for (int i = 1; i <= 5; i++) {
			Participante p = new Participante(rs, i);
			listaParticipantes.add(p);
			p.start();
		}
		
		Sorteo sorteo = new Sorteo(rs, 5);
		Thread t = new Thread(sorteo);
		
		t.start();
		t.join();
		
		for (Participante participante : listaParticipantes) {
			synchronized (participante) {
				participante.notify();	
			}
		}
		
		for (Participante participante : listaParticipantes) {
			participante.join();
		}
		
		System.out.println("[Programa] Hay ganador: El número premiado ha sido " + rs.consultarNumeroPremiado() + ".");
		
	}
	
}
