package com.albo.chb.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.chb.dao.IPesajeSoaChbDAO;
import com.albo.chb.model.Pesaje;
import com.albo.chb.model.PesajePK;
import com.albo.chb.service.IPesajeSoaChbService;
import com.albo.consulta.dto.PesajeRespuestaBdDTO;

@Service
public class PesajeSoaChbServiceImpl implements IPesajeSoaChbService {

	@Autowired
	private IPesajeSoaChbDAO pesajeSoaDao;

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
