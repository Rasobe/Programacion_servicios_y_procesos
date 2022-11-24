package Recu_examen;

public class ResultadoSorteo {
	
	private int numeroPremiado;
	
	public synchronized int consultarNumeroPremiado() {
		return numeroPremiado;
	}

	public void establecerNumeroPremiado(int numeroPremiado) {
		this.numeroPremiado = numeroPremiado;
	}
	
}
