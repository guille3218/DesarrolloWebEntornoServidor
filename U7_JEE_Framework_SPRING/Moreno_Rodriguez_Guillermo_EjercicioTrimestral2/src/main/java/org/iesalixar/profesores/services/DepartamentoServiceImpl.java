package org.iesalixar.profesores.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.iesalixar.profesores.model.Departamento;
import org.iesalixar.profesores.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DepartamentoServiceImpl implements DepartamentoService{

	@Autowired
	DepartamentoRepository departamentoRepo;
	
	@Override
	public List<Departamento> getAllDepartamentos() {

		// Obtengo el resultado a través del repositorio
		List<Departamento> deparBD = departamentoRepo.findAll();

		// Verificando que he obtenido algo
		if (deparBD != null && deparBD.size() > 0) {

			return deparBD;
		}

		// No he obtenido nada devuelvo una lista vacía (para no devolver nulo)
		return new ArrayList<Departamento>();
	}
	
	@Override
	public Optional<Departamento> findDepartamentoById(Long id) {
		
		Optional<Departamento> departamento = null;
		
		if (id!=null) {
			departamento = departamentoRepo.findById(id);
		}
		
		return departamento;
		
	}
}
