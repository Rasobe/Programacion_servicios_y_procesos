package CalculadoraAreas;

public class ProgramaPrincipal {

	public static void main(String[] args) throws InterruptedException {
		
		int MAX_HILOS = 100;
		Thread[] hilos = new Thread[MAX_HILOS];
		
		for (int i = 0; i < hilos.length; i++) {
			hilos[i] = new CalculadoraAreaTriangulo((float) Math.random() * 10 + 1, (float) Math.random() * 5 + 1);
			hilos[i].start();
		}
		
		for (Thread thread : hilos) {
			thread.join();
		}
		
	}
	
}
