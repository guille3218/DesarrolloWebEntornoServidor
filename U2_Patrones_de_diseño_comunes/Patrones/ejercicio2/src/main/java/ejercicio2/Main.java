package ejercicio2;

public class Main {
	public static void main(String[] args) {
		Figura f1 = FiguraFactory.getFigura("Circulo" , "Verde");
		Figura f2 = FiguraFactory.getFigura("Rectangulo" , "Amarillo");
		Figura f3 = FiguraFactory.getFigura("Triangulo" , "Rojo");
		Figura f4 = FiguraFactory.getFigura("Cuadrado" , "Azul");
		
		f1.dibujarFigura();
		f2.dibujarFigura();
		f3.dibujarFigura();
		f4.dibujarFigura();

		
	}
}
