package com.albo.tam.service;

import java.time.LocalDateTime;
import java.util.List;

import com.albo.consulta.dto.PesajeRespuestaBdDTO;
import com.albo.consulta.service.IService;
import com.albo.tam.model.Pesaje;
import com.albo.tam.model.PesajePK;

public interface IPesajeSoaTamService extends IService<Pesaje, PesajePK> {
	
	List<PesajeRespuestaBdDTO> listarPorPlacaFecha(String placa, LocalDateTime fechaInicial, LocalDateTime fechaFinal);
}
