package org.iesalixar.profesores.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.profesores.model.Profesor;
import org.iesalixar.profesores.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImpl implements ProfesorService {
	@Autowired
	ProfesorRepository profesorRepo;
	
	@Override
	public List<Profesor> getAllProfesores() {

		// Obtengo el resultado a través del repositorio
		List<Profesor> profBD = profesorRepo.findAll();

		// Verificando que he obtenido algo
		if (profBD != null && profBD.size() > 0) {

			return profBD;
		}

		// No he obtenido nada devuelvo una lista vacía (para no devolver nulo)
		return new ArrayList<Profesor>();
	}
	
	@Override
	public Optional<Profesor> findProfesorById(Long id) {
		
		Optional<Profesor> profesor = null;
		
		if (id!=null) {
			profesor = profesorRepo.findById(id);
		}
		
		return profesor;
		
	}
	
	@Override
	public Profesor insertarProfesor(Profesor profesor) {
		if (profesor!=null && findProfesorById(profesor.getId())==null) {
			Profesor prof = profesorRepo.save(profesor);
			return prof;
		}
		
		return null;
	}
}
