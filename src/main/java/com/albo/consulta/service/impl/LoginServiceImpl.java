package com.albo.consulta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.consulta.dao.ILoginDAO;
import com.albo.consulta.model.Usuario;
import com.albo.consulta.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService{
	
	@Autowired
	private ILoginDAO dao;

	@Override
	public int cambiarClave(String clave, String nombre) {
		int rpta = 0;
		try {
			dao.cambiarClave(clave, nombre);
			rpta = 1;
		} catch (Exception e) {
			rpta = 0;
		}
		return rpta;
	}
	
	@Override
	public Usuario verificarNombreUsuario(String usuario, String estado) {
//		Usuario us = null;
//		try {
//			us = dao.verificarNombreUsuario(usuario, estado);
//			us = us != null ? us : new Usuario();
//		} catch (Exception e) {
//			us = new Usuario();
//		}
//		return us;
		return dao.verificarNombreUsuario(usuario, estado);
	}
}
