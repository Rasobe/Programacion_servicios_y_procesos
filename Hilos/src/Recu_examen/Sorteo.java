package Recu_examen;

public class Sorteo implements Runnable {

	private ResultadoSorteo resultadoSorteo;
	private int numeroParticipantes;

	public Sorteo(ResultadoSorteo resultadoSorteo, int numeroParticipantes) {
		super();
		this.resultadoSorteo = resultadoSorteo;
		this.numeroParticipantes = numeroParticipantes;
	}

	@Override
	public void run() {
		try {
			Thread.currentThread().sleep(3000);
			resultadoSorteo.establecerNumeroPremiado((int) (Math.random() * numeroParticipantes) + 1);
			System.out.println("[Sorteo] Sorteo realizado, número premiado: " + resultadoSorteo.consultarNumeroPremiado());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
