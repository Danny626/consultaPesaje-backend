package com.albo.chb.service;

import java.time.LocalDateTime;
import java.util.List;

import com.albo.chb.model.Pesaje;
import com.albo.chb.model.PesajePK;
import com.albo.consulta.dto.PesajeRespuestaBdDTO;
import com.albo.consulta.service.IService;

public interface IPesajeSoaChbService extends IService<Pesaje, PesajePK> {
	
	List<PesajeRespuestaBdDTO> listarPorPlacaFecha(String placa, LocalDateTime fechaInicial, LocalDateTime fechaFinal);
}
