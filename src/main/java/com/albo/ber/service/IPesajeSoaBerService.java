package com.albo.ber.service;

import java.time.LocalDateTime;
import java.util.List;

import com.albo.ber.model.Pesaje;
import com.albo.ber.model.PesajePK;
import com.albo.consulta.dto.PesajeRespuestaBdDTO;
import com.albo.consulta.service.IService;

public interface IPesajeSoaBerService extends IService<Pesaje, PesajePK> {
	
	List<PesajeRespuestaBdDTO> listarPorPlacaFecha(String placa, LocalDateTime fechaInicial, LocalDateTime fechaFinal);
}
