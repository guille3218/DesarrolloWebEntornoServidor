package org.iesalixar.grados.services;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.grados.model.Grado;
import org.iesalixar.grados.repository.GradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradoServiceImpl implements GradoService{
	
	@Autowired
	GradoRepository gradoRepo;
	
	@Override
	public List<Grado> getAllGrados(){
		List<Grado> asignBD = gradoRepo.findAll();
		
		if (asignBD != null && asignBD.size() > 0) {

			return asignBD;
		}
		
		return new ArrayList<Grado>();
	}
	
	@Override
public Grado getGradoByName(String nombre) {
		
		if (nombre!=null) {
		
			Grado grado = gradoRepo.findByNombre(nombre);
			
			return grado; 			
		}
		
		return null;
	}
	
	@Override
	public Grado insertarGrado(Grado grado) {
		if (grado!=null && getGradoByName(grado.getNombre())==null) {
			Grado grad = gradoRepo.save(grado);
			return grad;
		}
		
		return null;
	}
	

}
