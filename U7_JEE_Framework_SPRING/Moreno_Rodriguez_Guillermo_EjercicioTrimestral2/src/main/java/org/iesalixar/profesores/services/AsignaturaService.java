package org.iesalixar.profesores.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.profesores.model.Asignatura;

public interface AsignaturaService {
	
	public List<Asignatura> getAllAsignaturas();
	public Optional<Asignatura> findAsignaturaById(Long id);

}
