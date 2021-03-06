package com.albo.consulta.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.albo.consulta.model.Usuario;

public interface IUsuarioService extends IService<Usuario, String> {

	Page<Usuario> listarPageable(Pageable pageable);

	Usuario listarPorUsername(String username);

	Page<Usuario> buscarXUsername(Pageable pageable, String username);
	
	byte[] leerArchivo(String pathFoto);
}
