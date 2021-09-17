package com.albo.consulta.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albo.consulta.model.Rol;

@Repository
public interface IRolDAO extends JpaRepository<Rol, String> {

}
