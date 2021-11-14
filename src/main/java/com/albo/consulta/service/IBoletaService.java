package com.albo.consulta.service;

public interface IBoletaService {

	byte[] generarBoleta(String pesoBruto, String pesoTara, String pesoNeto, String placa, String obs, String nombreRecinto, String nombreUsuario);
}
