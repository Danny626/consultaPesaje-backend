package com.albo.vil.service;

import java.time.LocalDateTime;
import java.util.List;

import com.albo.consulta.dto.PesajeRespuestaBdDTO;
import com.albo.consulta.service.IService;
import com.albo.vil.model.Pesaje;
import com.albo.vil.model.PesajePK;

public interface IPesajeSoaVilService extends IService<Pesaje, PesajePK> {
	
	List<PesajeRespuestaBdDTO> listarPorPlacaFecha(String placa, LocalDateTime fechaInicial, LocalDateTime fechaFinal);
}
