package com.albo.consulta.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operacion", schema = "PUBLIC")
public class Operacion implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/** Inicio Campos BD **/
	@Id
	@Column(name = "cod_operacion", nullable = false)
	private String codOperacion;

	@Column(name = "nombre", length = 50)
	private String nombre;
	/** Fin Campos BD **/

	public String getCodOperacion() {
		return codOperacion;
	}

	public void setCodOperacion(String codOperacion) {
		this.codOperacion = codOperacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
