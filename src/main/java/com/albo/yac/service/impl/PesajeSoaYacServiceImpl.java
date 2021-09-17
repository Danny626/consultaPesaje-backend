package com.albo.yac.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.consulta.dto.PesajeRespuestaBdDTO;
import com.albo.yac.dao.IPesajeSoaYacDAO;
import com.albo.yac.model.Pesaje;
import com.albo.yac.model.PesajePK;
import com.albo.yac.service.IPesajeSoaYacService;

@Service
public class PesajeSoaYacServiceImpl implements IPesajeSoaYacService {

	@Autowired
	private IPesajeSoaYacDAO pesajeSoaDao;

	@Override
	public List<Pesaje> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Pesaje> findById(PesajePK id) {
		// TODO Auto-generated method stub
		return null;
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
