package com.albo.war.service;

import java.time.LocalDateTime;
import java.util.List;

import com.albo.consulta.dto.PesajeRespuestaBdDTO;
import com.albo.consulta.service.IService;
import com.albo.war.model.Pesaje;
import com.albo.war.model.PesajePK;

public interface IPesajeSoaWarService extends IService<Pesaje, PesajePK> {
	
	List<PesajeRespuestaBdDTO> listarPorPlacaFecha(String placa, LocalDateTime fechaInicial, LocalDateTime fechaFinal);
}
