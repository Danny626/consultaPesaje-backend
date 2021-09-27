package com.albo.consulta.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.albo.consulta.model.Usuario;

@Repository
public interface ILoginDAO extends JpaRepository<Usuario, String>  {
	
	@Query("FROM Usuario us WHERE us.username = :usuario AND us.state = :estado ")
	Usuario verificarNombreUsuario(
		@Param("usuario") String usuario, 
		@Param("estado") String estado
	);
	
	@Transactional
	@Modifying
	@Query("UPDATE Usuario us SET us.password = :clave WHERE us.username = :nombre")
	void cambiarClave(@Param("clave") String clave, @Param("nombre") String nombre) throws Exception;
	
}
