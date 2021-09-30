package Singleton;

public class Presidente {
	
	private static String nombre;
	private static String apellidos;
	private static int selectionYear;
	
	private static Presidente presidente;
	
	public static Presidente getPresidente() {
		if(presidente == null) {
			presidente = new Presidente();
		}
		
		return presidente; 
	}
	
	public static String getNombre() {
		return nombre;
	}

	public static void setNombre(String nombre) {
		Presidente.nombre = nombre;
	}

	public static String getApellidos() {
		return apellidos;
	}

	public static void setApellidos(String apellidos) {
		Presidente.apellidos = apellidos;
	}

	public static int getSelectionYear() {
		return selectionYear;
	}

	public static void setSelectionYear(int selectionYear) {
		Presidente.selectionYear = selectionYear;
	}

	
}
