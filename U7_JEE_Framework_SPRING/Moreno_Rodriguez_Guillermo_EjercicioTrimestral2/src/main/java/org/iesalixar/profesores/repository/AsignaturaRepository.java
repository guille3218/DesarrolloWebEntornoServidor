package org.iesalixar.profesores.repository;

import org.iesalixar.profesores.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura,Long> {

	
}
