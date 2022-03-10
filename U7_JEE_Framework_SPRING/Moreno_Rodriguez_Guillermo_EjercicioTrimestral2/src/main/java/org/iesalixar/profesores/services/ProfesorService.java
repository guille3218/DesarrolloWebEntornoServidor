package org.iesalixar.profesores.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.profesores.model.Profesor;

public interface ProfesorService {
	public List<Profesor> getAllProfesores();
	public Optional<Profesor> findProfesorById(Long id);
	public Profesor insertarProfesor(Profesor profesor);
}
