package org.iesalixar.profesores.repository;

import org.iesalixar.profesores.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

	public Usuario findByUserName(String userName);
}
