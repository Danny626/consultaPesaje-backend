package com.albo.consulta.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface IBoletaService {

	byte[] generarBoleta(String pesoBruto, String pesoTara, String pesoNeto, String placa, String obs, String nombreRecinto, String nombreUsuario);
	
	byte[] generarBoletaNueva(String nombreRecinto, Integer codPesaje, LocalDateTime fecha, BigDecimal pesoBruto, String placa);
}
