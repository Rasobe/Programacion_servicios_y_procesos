package CalculadoraAreas;

public class CalculadoraAreaTriangulo extends Thread {

	private float base;
	private float altura;
	private float area;

	public CalculadoraAreaTriangulo(float base, float altura) {
		super();
		this.base = base;
		this.altura = altura;
		this.area = base * altura / 2;
	}

	@Override
	public void run() {
		super.run();

		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + " -> Base: " + base + ", Altura: " + altura + " = " + area);
		}

	}

}
