package org.iesalixar.servidor.model;

public class Reserva {
	
	private String fechaInicio;
	private String fechaFin;
	private int Personas;
	private String[] servicios;
	
	public Reserva() {
		// TODO Auto-generated constructor stub
	}
	
	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getPersonas() {
		return Personas;
	}

	public void setPersonas(int personas) {
		Personas = personas;
	}

	public String[] getServicios() {
		return servicios;
	}

	public void setServicios(String[] servicios) {
		this.servicios = servicios;
	}

}
