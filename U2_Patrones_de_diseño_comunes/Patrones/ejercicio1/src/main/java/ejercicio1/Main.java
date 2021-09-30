package ejercicio1;

public class Main {
	public static void main(String[] args) {
		
		Tejado t1 = new Tejado();
		Pared p1 = new Pared(12);
		Pared p2 = new Pared(12);
		Pared p3 = new Pared(12);
		Pared p4 = new Pared(12);
		
		Casa c1 = new Casa(13.2,t1,p1,p2,p3,p4) ;
		
		Casa c2 = new Casa(20.3,new TejadoTejas(),new Pared(23),new Pared(12),new Pared(15),new Pared(16));
		
		c1.getTejado().darSoporte();
		c2.getTejado().darSoporte();
	}
}
