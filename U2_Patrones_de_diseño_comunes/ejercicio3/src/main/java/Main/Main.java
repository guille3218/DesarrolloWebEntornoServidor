package Main;

import Singleton.Presidente;

public class Main {

	public static void main(String[] args) {
		Presidente p1 = Presidente.getPresidente();
		Presidente p2 = Presidente.getPresidente();
		
		Presidente.setNombre("Pedro");
		Presidente.setApellidos("Lopez");
		Presidente.setSelectionYear(2001);
		
		System.out.println("p1 = " + p1.getNombre() + " " + p1.getApellidos() + " " + p1.getSelectionYear());
		System.out.println("p2 = " + p2.getNombre() + " " + p2.getApellidos() + " " + p2.getSelectionYear());
		
		System.out.println(p1.equals(p2));
		
		p1.setNombre("Daniel");
		p1.setApellidos("Gonzalez");
		p1.setSelectionYear(2011);
		

		System.out.println("p1 = " + p1.getNombre() + " " + p1.getApellidos() + " " + p1.getSelectionYear());
		System.out.println("p2 = " + p2.getNombre() + " " + p2.getApellidos() + " " + p2.getSelectionYear());
		
		
		System.out.println(p1.equals(p2));
	}
}
