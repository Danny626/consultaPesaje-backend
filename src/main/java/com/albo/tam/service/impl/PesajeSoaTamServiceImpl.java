package com.albo.tam.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.consulta.dto.PesajeRespuestaBdDTO;
import com.albo.tam.dao.IPesajeSoaTamDAO;
import com.albo.tam.model.Pesaje;
import com.albo.tam.model.PesajePK;
import com.albo.tam.service.IPesajeSoaTamService;

@Service
public class PesajeSoaTamServiceImpl implements IPesajeSoaTamService {

	@Autowired
	private IPesajeSoaTamDAO pesajeSoaDao;

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
