package ejercicio2;

public class FiguraFactory {
	public static Figura getFigura(String forma, String color) {
		if(forma.equals("Triangulo")) {
			Triangulo t1 = new Triangulo();
			t1.setColor(color);
			return t1;
		}else if (forma.equals("Rectangulo")) {
			Rectangulo r1 = new Rectangulo();
			r1.setColor(color);
			return r1;
		}else if (forma.equals("Circulo")) {
			Circulo c1 = new Circulo();
			c1.setColor(color);
			return c1;
		}else {
			Cuadrado c2 = new Cuadrado();
			c2.setColor(color);
			return c2;
		}
	}
}
