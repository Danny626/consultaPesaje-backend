package com.albo.yac.service;

import java.time.LocalDateTime;
import java.util.List;

import com.albo.consulta.dto.PesajeRespuestaBdDTO;
import com.albo.consulta.service.IService;
import com.albo.yac.model.Pesaje;
import com.albo.yac.model.PesajePK;

public interface IPesajeSoaYacService extends IService<Pesaje, PesajePK> {
	
	List<PesajeRespuestaBdDTO> listarPorPlacaFecha(String placa, LocalDateTime fechaInicial, LocalDateTime fechaFinal);
}
