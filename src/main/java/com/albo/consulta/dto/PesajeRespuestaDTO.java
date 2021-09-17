package com.albo.consulta.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PesajeRespuestaDTO {

	private Integer gestion;
	private String placa;
	private BigDecimal peso;
	private LocalDateTime fechaBlz;
	private String usrCod;
	private String observacion;
	private Integer numeracion;
	private String recintoCod;
	
	public Integer getGestion() {
		return gestion;
	}
	public void setGestion(Integer gestion) {
		this.gestion = gestion;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public LocalDateTime getFechaBlz() {
		return fechaBlz;
	}
	public void setFechaBlz(LocalDateTime fechaBlz) {
		this.fechaBlz = fechaBlz;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Integer getNumeracion() {
		return numeracion;
	}
	public void setNumeracion(Integer numeracion) {
		this.numeracion = numeracion;
	}
	public BigDecimal getPeso() {
		return peso;
	}
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
	public String getUsrCod() {
		return usrCod;
	}
	public void setUsrCod(String usrCod) {
		this.usrCod = usrCod;
	}
	public String getRecintoCod() {
		return recintoCod;
	}
	public void setRecintoCod(String recintoCod) {
		this.recintoCod = recintoCod;
	}

}
