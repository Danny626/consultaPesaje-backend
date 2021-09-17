package com.albo.consulta.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recinto", schema = "PUBLIC")
public class Recinto implements Serializable {

	private static final long serialVersionUID = 1L;

	/** inicio campos bd **/
	@Id
	@Column(name = "rec_cod", nullable = false, length = 5)
	private String recCod;

	@Column(name = "nombre", length = 50)
	private String nombre;

	@Column(name = "nombrea", length = 50)
	private String nombrea;

	@Column(name = "estado", length = 5)
	private String estado;

	@Column(name = "tipo", length = 10)
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "adu_cod", referencedColumnName = "adu_cod")
	private Aduana aduana;

	/** fin campos bd **/

	/** inicio getters y setters **/

	public String getRecCod() {
		return recCod;
	}

	public void setRecCod(String recCod) {
		this.recCod = recCod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombrea() {
		return nombrea;
	}

	public void setNombrea(String nombrea) {
		this.nombrea = nombrea;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/** fin getters y setters **/

}
