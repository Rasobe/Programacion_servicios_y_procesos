package Filosofos;

public class Filosofo2 extends Thread {
	
	private int numeroFilosofo;
	private int numeroCubiertos;

	public Filosofo2(int numeroFilosofo) {
		super();
		this.numeroFilosofo = numeroFilosofo;
		this.numeroCubiertos = 0;
	}



	@Override
	public void run() {
		super.run();		
		synchronized (this) {			
			while (numeroCubiertos < 2) {
				numeroCubiertos++;			
			}
			
			try {
				// comiendo
				int numeroAleatorio = (int) (Math.random() * 2 + 1);
				System.out.println("Filosofo " + numeroFilosofo + " está comiendo.");
				numeroCubiertos = 0;
				Thread.sleep(1000 * numeroAleatorio);
				
				// pensando
				numeroAleatorio = (int) (Math.random() * 5 + 1);
				System.out.println("Filosofo " + numeroFilosofo + " está pensando.");
				Thread.sleep(1000 * numeroAleatorio);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	

}
