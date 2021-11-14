package com.albo.ber.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.ber.dao.IPesajeSoaBerDAO;
import com.albo.ber.model.Pesaje;
import com.albo.ber.model.PesajePK;
import com.albo.ber.service.IPesajeSoaBerService;
import com.albo.consulta.dto.PesajeRespuestaBdDTO;

@Service
public class PesajeSoaBerServiceImpl implements IPesajeSoaBerService {

	@Autowired
	private IPesajeSoaBerDAO pesajeSoaDao;

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
