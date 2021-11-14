package com.albo.war.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.consulta.dto.PesajeRespuestaBdDTO;
import com.albo.war.dao.IPesajeSoaWarDAO;
import com.albo.war.model.Pesaje;
import com.albo.war.model.PesajePK;
import com.albo.war.service.IPesajeSoaWarService;

@Service
public class PesajeSoaWarServiceImpl implements IPesajeSoaWarService {

	@Autowired
	private IPesajeSoaWarDAO pesajeSoaDao;

	@Override
	public List<Pesaje> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Pesaje> findById(PesajePK id) {
		return pesajeSoaDao.findById(id);
	}

	@Override
	public Pesaje saveOrUpdate(Pesaje t) {
		return pesajeSoaDao.save(t);
	}

	@Override
	public Boolean deleteById(PesajePK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PesajeRespuestaBdDTO> listarPorPlacaFecha(String placa, LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
		return pesajeSoaDao.listarPorPlacaFecha(placa, fechaInicial, fechaFinal);
	}

}
