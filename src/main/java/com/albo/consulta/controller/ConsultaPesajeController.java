package com.albo.consulta.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albo.ber.service.IPesajeSoaBerService;
import com.albo.chb.service.IPesajeSoaChbService;
import com.albo.consulta.dto.PesajeRespuestaBdDTO;
import com.albo.consulta.dto.PesajeRespuestaDTO;
import com.albo.consulta.service.IOperacionService;
import com.albo.consulta.service.IRecintoService;
import com.albo.pam.service.IPesajeSoaPamService;
import com.albo.psg.service.IPesajeSoaPsgService;
import com.albo.tam.service.IPesajeSoaTamService;
import com.albo.vil.service.IPesajeSoaVilService;
import com.albo.war.service.IPesajeSoaWarService;
import com.albo.yac.service.IPesajeSoaYacService;

@RestController
@RequestMapping("/consultaPesaje")
public class ConsultaPesajeController {
	
	private static final Logger LOGGER = LogManager.getLogger(ConsultaPesajeController.class);
	
	@Autowired
	private IPesajeSoaBerService berService;
	
	@Autowired
	private IPesajeSoaChbService chbService;
	
	@Autowired
	private IPesajeSoaPamService pamService;
	
	@Autowired
	private IPesajeSoaPsgService psgService;
	
	@Autowired
	private IPesajeSoaTamService tamService;
	
	@Autowired
	private IPesajeSoaVilService vilService;
	
	@Autowired
	private IPesajeSoaWarService warService;
	
	@Autowired
	private IPesajeSoaYacService yacService;
	
	@Autowired
	private IRecintoService recintoService;
	
	@Autowired
	private IOperacionService operacionService;
	
	/**
	 * Función q busca los pesajes por placa, fecha y recinto
	 * @param placa 		placa en formato (123ABC, sin espacios)
	 * @param fechaInicial	fecha en formato (31-01-2021)
	 * @param fechaFinal	fecha en formato (31-01-2021)
	 * @param recinto		recinto en formato (TAM01)
	 * @return	devuelve la lista de pesajes
	 */
	@GetMapping(value = "/consultaPlaca/{placa}/{fechaInicial}/{fechaFinal}/{recinto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listarPesajesPorPlacaFechaRecinto(
		@PathVariable("placa") String placa,
		@PathVariable("fechaInicial") String fechaInicial,
		@PathVariable("fechaFinal") String fechaFinal,
		@PathVariable("recinto") String recinto
	) {
		
		List<PesajeRespuestaDTO> pesajesRespuesta = new ArrayList<PesajeRespuestaDTO>();
		
		// verificamos q el cód de recinto sea correcto
		if ( !recintoService.findById(recinto).isPresent() ) {
			return new ResponseEntity<String>("Error. Código de recinto inválido", HttpStatus.BAD_REQUEST);
		}

		// armamos la fecha inicial
		LocalDateTime fechaInicioProceso = this.fechaStringToDate(fechaInicial + " 00:00:00");
		LOGGER.info("fechaInicioProceso: " + fechaInicioProceso);

		// armamos la fecha final
		LocalDateTime fechaFinalProceso = this.fechaStringToDate(fechaFinal + " 23:59:59");
		LOGGER.info("fechaFinalProceso: " + fechaFinalProceso);
		
		// realizamos la búsqueda de acuerdo al recinto
		switch (recinto) {
		case "BER01": {
			
			LOGGER.info("BERMEJO");
			List<PesajeRespuestaBdDTO> pesajes = berService.listarPorPlacaFecha(placa, fechaInicioProceso, fechaFinalProceso);
			pesajesRespuesta = this.busquedaPesajes(pesajes, recinto);
			break;
		}
		case "CHB01": {
			
			LOGGER.info("COCHA");
			List<PesajeRespuestaBdDTO> pesajes = chbService.listarPorPlacaFecha(placa, fechaInicioProceso, fechaFinalProceso);
			pesajesRespuesta = this.busquedaPesajes(pesajes, recinto);
			break;
		}
		case "PAM01": {
			
			LOGGER.info("PAMPA");
			List<PesajeRespuestaBdDTO> pesajes = pamService.listarPorPlacaFecha(placa, fechaInicioProceso, fechaFinalProceso);
			pesajesRespuesta = this.busquedaPesajes(pesajes, recinto);
			break;
		}
		case "PSG01": {
			
			LOGGER.info("PISIGA");
			List<PesajeRespuestaBdDTO> pesajes = psgService.listarPorPlacaFecha(placa, fechaInicioProceso, fechaFinalProceso);
			pesajesRespuesta = this.busquedaPesajes(pesajes, recinto);
			break;
		}
		case "TAM01": {
			
			LOGGER.info("TAMBO");
			List<PesajeRespuestaBdDTO> pesajes = tamService.listarPorPlacaFecha(placa, fechaInicioProceso, fechaFinalProceso);
			pesajesRespuesta = this.busquedaPesajes(pesajes, recinto);
			break;
		}
		case "VIL01": {
			
			LOGGER.info("VILLAZON");
			List<PesajeRespuestaBdDTO> pesajes = vilService.listarPorPlacaFecha(placa, fechaInicioProceso, fechaFinalProceso);
			pesajesRespuesta = this.busquedaPesajes(pesajes, recinto);
			break;
		}
		case "SCZ07": {
			
			LOGGER.info("WARNES");
			List<PesajeRespuestaBdDTO> pesajes = warService.listarPorPlacaFecha(placa, fechaInicioProceso, fechaFinalProceso);
			pesajesRespuesta = this.busquedaPesajes(pesajes, recinto);
			break;
		}
		case "YAC01": {
			LOGGER.info("YACUIBA");
			List<PesajeRespuestaBdDTO> pesajes = yacService.listarPorPlacaFecha(placa, fechaInicioProceso, fechaFinalProceso);
			pesajesRespuesta = this.busquedaPesajes(pesajes, recinto);
			break;
		}
		default:
			return new ResponseEntity<String>("Error. Código de recinto sin tratamiento", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<List<PesajeRespuestaDTO>>(pesajesRespuesta, HttpStatus.OK);
	}
	
	/**
	 * funcion q convierte un texto con la fecha a LocalDateTime
	 */
	public LocalDateTime fechaStringToDate(String cadenaFecha) {
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime fechaconvertida = LocalDateTime.parse(cadenaFecha, formatoFecha);
		return fechaconvertida;
	}
	
	public List<PesajeRespuestaDTO> busquedaPesajes(List<PesajeRespuestaBdDTO> pesajes, String recintoCod) {
		List<PesajeRespuestaDTO> pesajesRespuesta = new ArrayList<PesajeRespuestaDTO>();
		
		pesajes.forEach(p -> {
			PesajeRespuestaDTO pesajeRespuesta = new PesajeRespuestaDTO();
			pesajeRespuesta.setFechaBlz(p.getPsjFechaBlz());
			pesajeRespuesta.setGestion(p.getPsjGestion().intValue());
			pesajeRespuesta.setNumeracion(p.getPsjNumeracion()!=null?p.getPsjNumeracion().intValue():null);
			pesajeRespuesta.setObservacion(p.getPsjObservacion());
			pesajeRespuesta.setPlaca(p.getPsjPlaca());
			pesajeRespuesta.setRecintoCod(recintoCod);
			pesajeRespuesta.setUsrCod(p.getUsrCod());
			pesajeRespuesta.setCodPesaje(p.getPsjCod().intValue());
			pesajeRespuesta.setPesoBruto(p.getPsjPeso());
			pesajeRespuesta.setPesoNeto(p.getPsjNeto());
			pesajeRespuesta.setPesoTara(p.getPsjTara());
			pesajeRespuesta.setOperacion(operacionService.findById(p.getPsjOperacion()).get());
			
			pesajesRespuesta.add(pesajeRespuesta);
		});
		
		return pesajesRespuesta;
	}

}
