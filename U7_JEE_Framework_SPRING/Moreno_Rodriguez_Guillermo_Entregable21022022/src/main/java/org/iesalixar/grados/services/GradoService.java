package org.iesalixar.grados.services;

import java.util.List;

import org.iesalixar.grados.model.Grado;

public interface GradoService {

	public List<Grado> getAllGrados();
	public Grado getGradoByName(String nombre);
	public Grado insertarGrado(Grado grado);
}
