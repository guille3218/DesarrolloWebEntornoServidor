package org.iesalixar.grados.repository;

import org.iesalixar.grados.model.Grado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradoRepository extends JpaRepository<Grado,Long>{

	public Grado findByNombre(String nombre);
}
