package com.albo.consulta.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.albo.consulta.model.Rol;

public interface IRolService extends IService<Rol, String> {

	Page<Rol> listarPageable(Pageable pageable);
}
