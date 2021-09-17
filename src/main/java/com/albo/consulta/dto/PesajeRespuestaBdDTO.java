package com.albo.consulta.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

public class PesajeRespuestaBdDTO {

	private BigInteger psjGestion;
	private BigInteger psjCod;
	private String psjPlaca;
	private BigDecimal psjPeso;
	private LocalDateTime psjFecha;
	private String psjEstado;
	private String blzCod;
	private String psjObservacion;
	private String mnfCod;
	private String usrCod;
	private String psjOperacion;
	private BigDecimal psjTara;
	private BigDecimal psjNeto;
	private String ticCod;
	private LocalDateTime psjFechaBlz;
	private LocalDateTime psjFechaRegistro;
	private BigInteger psjNumeracion;
	private String psjCodcontrol;
	
	public PesajeRespuestaBdDTO(BigInteger psjGestion, BigInteger psjCod, String psjPlaca, BigDecimal psjPeso,
			LocalDateTime psjFecha, String psjEstado, String blzCod, String psjObservacion, String mnfCod,
			String usrCod, String psjOperacion, BigDecimal psjTara, BigDecimal psjNeto, String ticCod, LocalDateTime psjFechaBlz,
			LocalDateTime psjFechaRegistro, BigInteger psjNumeracion, String psjCodcontrol) {
		this.psjGestion = psjGestion;
		this.psjCod = psjCod;
		this.psjPlaca = psjPlaca;
		this.psjPeso = psjPeso;
		this.psjFecha = psjFecha;
		this.psjEstado = psjEstado;
		this.blzCod = blzCod;
		this.psjObservacion = psjObservacion;
		this.mnfCod = mnfCod;
		this.usrCod = usrCod;
		this.psjOperacion = psjOperacion;
		this.psjTara = psjTara;
		this.psjNeto = psjNeto;
		this.ticCod = ticCod;
		this.psjFechaBlz = psjFechaBlz;
		this.psjFechaRegistro = psjFechaRegistro;
		this.psjNumeracion = psjNumeracion;
		this.psjCodcontrol = psjCodcontrol;
	}
	
	public BigInteger getPsjGestion() {
		return psjGestion;
	}
	public void setPsjGestion(BigInteger psjGestion) {
		this.psjGestion = psjGestion;
	}
	public BigInteger getPsjCod() {
		return psjCod;
	}
	public void setPsjCod(BigInteger psjCod) {
		this.psjCod = psjCod;
	}
	public String getPsjPlaca() {
		return psjPlaca;
	}
	public void setPsjPlaca(String psjPlaca) {
		this.psjPlaca = psjPlaca;
	}
	public BigDecimal getPsjPeso() {
		return psjPeso;
	}
	public void setPsjPeso(BigDecimal psjPeso) {
		this.psjPeso = psjPeso;
	}
	public LocalDateTime getPsjFecha() {
		return psjFecha;
	}
	public void setPsjFecha(LocalDateTime psjFecha) {
		this.psjFecha = psjFecha;
	}
	public String getPsjEstado() {
		return psjEstado;
	}
	public void setPsjEstado(String psjEstado) {
		this.psjEstado = psjEstado;
	}
	public String getBlzCod() {
		return blzCod;
	}
	public void setBlzCod(String blzCod) {
		this.blzCod = blzCod;
	}
	public String getPsjObservacion() {
		return psjObservacion;
	}
	public void setPsjObservacion(String psjObservacion) {
		this.psjObservacion = psjObservacion;
	}
	public String getMnfCod() {
		return mnfCod;
	}
	public void setMnfCod(String mnfCod) {
		this.mnfCod = mnfCod;
	}
	public String getUsrCod() {
		return usrCod;
	}
	public void setUsrCod(String usrCod) {
		this.usrCod = usrCod;
	}
	public String getPsjOperacion() {
		return psjOperacion;
	}
	public void setPsjOperacion(String psjOperacion) {
		this.psjOperacion = psjOperacion;
	}
	public BigDecimal getPsjTara() {
		return psjTara;
	}
	public void setPsjTara(BigDecimal psjTara) {
		this.psjTara = psjTara;
	}
	public BigDecimal getPsjNeto() {
		return psjNeto;
	}
	public void setPsjNeto(BigDecimal psjNeto) {
		this.psjNeto = psjNeto;
	}
	public LocalDateTime getPsjFechaBlz() {
		return psjFechaBlz;
	}
	public void setPsjFechaBlz(LocalDateTime psjFechaBlz) {
		this.psjFechaBlz = psjFechaBlz;
	}
	public LocalDateTime getPsjFechaRegistro() {
		return psjFechaRegistro;
	}
	public void setPsjFechaRegistro(LocalDateTime psjFechaRegistro) {
		this.psjFechaRegistro = psjFechaRegistro;
	}
	public BigInteger getPsjNumeracion() {
		return psjNumeracion;
	}
	public void setPsjNumeracion(BigInteger psjNumeracion) {
		this.psjNumeracion = psjNumeracion;
	}
	public String getPsjCodcontrol() {
		return psjCodcontrol;
	}
	public void setPsjCodcontrol(String psjCodcontrol) {
		this.psjCodcontrol = psjCodcontrol;
	}
	public String getTicCod() {
		return ticCod;
	}
	public void setTicCod(String ticCod) {
		this.ticCod = ticCod;
	}
	
}
