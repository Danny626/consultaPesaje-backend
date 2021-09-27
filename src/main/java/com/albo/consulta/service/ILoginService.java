package com.albo.consulta.service;

import com.albo.consulta.model.Usuario;

public interface ILoginService {

	Usuario verificarNombreUsuario(String usuario, String estado);

	int cambiarClave(String clave, String nombre) throws Exception;

}
