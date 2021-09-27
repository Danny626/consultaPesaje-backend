package com.albo.consulta.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.consulta.dao.IOperacionDAO;
import com.albo.consulta.model.Operacion;
import com.albo.consulta.service.IOperacionService;

@Service
public class OperacionServiceImpl implements IOperacionService {

	@Autowired
	private IOperacionDAO operacionDao;
	
	@Override
	public List<Operacion> findAll() {
		return operacionDao.findAll();
	}

	@Override
	public Optional<Operacion> findById(String id) {
		return operacionDao.findById(id);
	}

	@Override
	public Operacion saveOrUpdate(Operacion t) {
		return operacionDao.save(t);
	}

	@Override
	public Boolean deleteById(String id) {
		if (!operacionDao.existsById(id)) {
			return false;
		}
		
		operacionDao.deleteById(id);
		return true;
	}

}
