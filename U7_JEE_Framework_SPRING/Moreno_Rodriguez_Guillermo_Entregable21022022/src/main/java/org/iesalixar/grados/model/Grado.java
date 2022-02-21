package org.iesalixar.grados.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="grado")
public class Grado implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_grado;
	
	@Column(nullable=false)
	private String nombre;
	
	@OneToMany(mappedBy="grado",cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Asignatura> asignaturas = new HashSet<>();
	
	public Grado() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId_grado() {
		return id_grado;
	}

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	//Metodo Helper
	
	public void addAsignatura(Asignatura asignatura) {
		this.asignaturas.add(asignatura);
		asignatura.setGrado(this);
	}
	
}
