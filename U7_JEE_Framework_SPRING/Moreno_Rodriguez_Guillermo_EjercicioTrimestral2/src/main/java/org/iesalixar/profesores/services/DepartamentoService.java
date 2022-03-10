package org.iesalixar.profesores.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.profesores.model.Departamento;

public interface DepartamentoService {
	public List<Departamento> getAllDepartamentos();
	public Optional<Departamento> findDepartamentoById(Long id);
}
