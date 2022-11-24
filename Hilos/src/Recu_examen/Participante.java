package Recu_examen;

public class Participante extends Thread {

	private ResultadoSorteo resultadoSorteo;
	private int numeroBoleto;
	
	public Participante(ResultadoSorteo resultadoSorteo, int numeroBoleto) {
		super();
		this.resultadoSorteo = resultadoSorteo;
		this.numeroBoleto = numeroBoleto;
	}

	

	@Override
	public void run() {
		synchronized (this) {
			try {
				this.wait();
				
				if (numeroBoleto == resultadoSorteo.consultarNumeroPremiado()) {
					System.out.println("[Participante] Soy el hilo " + Thread.currentThread().getName() + " ¡He ganado el sorteo!");
				} else {
					System.out.println("[Participante] Soy el hilo " + Thread.currentThread().getName() + " no ha habido suerte.");
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
