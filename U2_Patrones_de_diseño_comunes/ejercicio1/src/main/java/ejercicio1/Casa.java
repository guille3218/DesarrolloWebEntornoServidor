package ejercicio1;

public class Casa {
	
	private double area;
	private Tejado tejado;
	private Pared p1;
	private Pared p2;
	private Pared p3;
	private Pared p4;
	
	
	public Casa(double area, Tejado tejado, Pared p1, Pared p2, Pared p3, Pared p4) {
		this.area = area;
		this.tejado = tejado;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
	}
	
	public double getArea() {
		return area;
	}


	public void setArea(double area) {
		this.area = area;
	}


	public Tejado getTejado() {
		return tejado;
	}


	public void setTejado(Tejado tejado) {
		this.tejado = tejado;
	}


	public Pared getP1() {
		return p1;
	}


	public void setP1(Pared p1) {
		this.p1 = p1;
	}


	public Pared getP2() {
		return p2;
	}


	public void setP2(Pared p2) {
		this.p2 = p2;
	}


	public Pared getP3() {
		return p3;
	}


	public void setP3(Pared p3) {
		this.p3 = p3;
	}


	public Pared getP4() {
		return p4;
	}


	public void setP4(Pared p4) {
		this.p4 = p4;
	}


	
	
	
}
