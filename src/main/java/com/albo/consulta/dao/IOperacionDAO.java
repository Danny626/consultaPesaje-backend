package com.albo.consulta.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albo.consulta.model.Operacion;

@Repository
public interface IOperacionDAO extends JpaRepository<Operacion, String> {

}
