package com.albo.psg.service;

import java.time.LocalDateTime;
import java.util.List;

import com.albo.consulta.dto.PesajeRespuestaBdDTO;
import com.albo.consulta.service.IService;
import com.albo.psg.model.Pesaje;
import com.albo.psg.model.PesajePK;

public interface IPesajeSoaPsgService extends IService<Pesaje, PesajePK> {
	
	List<PesajeRespuestaBdDTO> listarPorPlacaFecha(String placa, LocalDateTime fechaInicial, LocalDateTime fechaFinal);
}
