package com.albo.tam.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.albo.consulta.dto.PesajeRespuestaBdDTO;
import com.albo.tam.model.Pesaje;
import com.albo.tam.model.PesajePK;

@Repository
public interface IPesajeSoaTamDAO extends JpaRepository<Pesaje, PesajePK> {
	
	// @Query("FROM com.albo.tam.model.Pesaje WHERE psjPlaca = :placa AND psjFechaBlz >= :fechaInicial AND psjFechaBlz <= :fechaFinal AND p.psjOperacion != 'DES' AND p.psjEstado != 'ANU'")
	@Query("SELECT new com.albo.consulta.dto.PesajeRespuestaBdDTO(p.pesajePK.psjGestion, p.pesajePK.psjCod, p.psjPlaca, p.psjPeso, p.psjFecha, p.psjEstado, p.blzCod, p.psjObservacion, p.mnfCod, p.usrCod, p.psjOperacion, p.psjTara, p.psjNeto, p.ticCod.ticCod, p.psjFechaBlz, p.psjFechaRegistro, p.psjNumeracion, p.psjCodcontrol) "
			+ "FROM com.albo.tam.model.Pesaje p WHERE p.psjPlaca = :placa AND p.psjFecha >= :fechaInicial AND p.psjFecha <= :fechaFinal AND p.psjOperacion != 'DES' AND p.psjEstado != 'ANU'")
	List<PesajeRespuestaBdDTO> listarPorPlacaFecha(@Param("placa") String placa, @Param("fechaInicial") LocalDateTime fechaInicial, @Param("fechaFinal") LocalDateTime fechaFinal);
	
}
