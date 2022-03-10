package org.iesalixar.profesores.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="profesor")
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=true)
	private String nif;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String apellido1;
	
	@Column(nullable=true)
	private String apellido2;
	
	@Column(nullable=false)
	private String ciudad;
	
	@Column(nullable=false)
	private String direccion;
	
	@Column(nullable=true)
	private String telefono;
	
	@Column(name="fecha_nacimiento",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column(nullable=false,length=1)
	private String sexo;
	
	@Column(nullable=false)
	private Long id_departamento;
	
	private String departamento;
	
	@OneToMany(mappedBy="profesor",cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Asignatura> asignaturas = new HashSet<>();
	

	
	public Profesor() {
		// TODO Auto-generated constructor stub
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Long getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(Long id_departamento) {
		this.id_departamento = id_departamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		asignatura.setProfesor(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido1, apellido2, ciudad, direccion, fechaNacimiento, id, id_departamento, nif, nombre,
				sexo, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(apellido1, other.apellido1) && Objects.equals(apellido2, other.apellido2)
				&& Objects.equals(ciudad, other.ciudad) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(id, other.id)
				&& Objects.equals(id_departamento, other.id_departamento) && Objects.equals(nif, other.nif)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(sexo, other.sexo)
				&& Objects.equals(telefono, other.telefono);
	}
	
	
	
}
