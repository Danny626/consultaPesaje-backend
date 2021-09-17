package com.albo.consulta.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albo.consulta.model.Recinto;

@Repository
public interface IRecintoDAO extends JpaRepository<Recinto, String> {

}
