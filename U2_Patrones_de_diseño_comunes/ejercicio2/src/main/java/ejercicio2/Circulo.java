package ejercicio2;

public class Circulo extends Figura {

	@Override
	public void dibujarFigura() {
		System.out.println("Soy un circulo de color " + super.getColor());
		
	}
}