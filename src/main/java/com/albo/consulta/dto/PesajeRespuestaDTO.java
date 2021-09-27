package com.albo.consulta.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.albo.consulta.model.Operacion;

public class PesajeRespuestaDTO {

	private Integer gestion;
	private Integer codPesaje;
	private String placa;
	private BigDecimal pesoBruto;
	private BigDecimal pesoNeto;
	private BigDecimal pesoTara;
	private LocalDateTime fechaBlz;
	private String usrCod;
	private String observacion;
	private Integer numeracion;
	private Operacion operacion;
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
	public Integer getCodPesaje() {
		return codPesaje;
	}
	public void setCodPesaje(Integer codPesaje) {
		this.codPesaje = codPesaje;
	}
	public BigDecimal getPesoBruto() {
		return pesoBruto;
	}
	public void setPesoBruto(BigDecimal pesoBruto) {
		this.pesoBruto = pesoBruto;
	}
	public BigDecimal getPesoNeto() {
		return pesoNeto;
	}
	public void setPesoNeto(BigDecimal pesoNeto) {
		this.pesoNeto = pesoNeto;
	}
	public BigDecimal getPesoTara() {
		return pesoTara;
	}
	public void setPesoTara(BigDecimal pesoTara) {
		this.pesoTara = pesoTara;
	}
	public Operacion getOperacion() {
		return operacion;
	}
	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}

}
