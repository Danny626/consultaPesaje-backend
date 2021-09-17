package com.albo.consulta.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.consulta.dao.IRecintoDAO;
import com.albo.consulta.model.Recinto;
import com.albo.consulta.service.IRecintoService;

@Service
public class RecintoServiceImpl implements IRecintoService {

	@Autowired
	private IRecintoDAO recintoDao;
	
	@Override
	public List<Recinto> findAll() {
		return recintoDao.findAll();
	}

	@Override
	public Optional<Recinto> findById(String id) {
		return recintoDao.findById(id);
	}

	@Override
	public Recinto saveOrUpdate(Recinto t) {
		return recintoDao.save(t);
	}

	@Override
	public Boolean deleteById(String id) {
		if (!recintoDao.existsById(id)) {
			return false;
		}
		
		recintoDao.deleteById(id);
		return true;
	}

}
