package com.albo.chb.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.albo.chb.model.Pesaje;
import com.albo.chb.model.PesajePK;
import com.albo.consulta.dto.PesajeRespuestaBdDTO;

@Repository
public interface IPesajeSoaChbDAO extends JpaRepository<Pesaje, PesajePK> {
	
	// @Query("FROM com.albo.chb.model.Pesaje WHERE psjPlaca = :placa AND psjFechaBlz >= :fechaInicial AND psjFechaBlz <= :fechaFinal AND p.psjOperacion != 'DES'")
	@Query("SELECT new com.albo.consulta.dto.PesajeRespuestaBdDTO(p.pesajePK.psjGestion, p.pesajePK.psjCod, p.psjPlaca, p.psjPeso, p.psjFecha, p.psjEstado, p.blzCod, p.psjObservacion, p.mnfCod, p.usrCod, p.psjOperacion, p.psjTara, p.psjNeto, p.ticCod.ticCod, p.psjFechaBlz, p.psjFechaRegistro, p.psjNumeracion, p.psjCodcontrol) "
			+ "FROM com.albo.chb.model.Pesaje p WHERE p.psjPlaca = :placa AND p.psjFechaBlz >= :fechaInicial AND p.psjFechaBlz <= :fechaFinal AND p.psjOperacion != 'DES'")
	List<PesajeRespuestaBdDTO> listarPorPlacaFecha(@Param("placa") String placa, @Param("fechaInicial") LocalDateTime fechaInicial, @Param("fechaFinal") LocalDateTime fechaFinal);
	
}
