package com.albo.consulta.controller;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.albo.consulta.model.Recinto;
import com.albo.consulta.service.IBoletaService;
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
	
	@Autowired
	private IBoletaService boletaService;
	
	/**
	 * Funci??n q busca los pesajes por placa, fecha y recinto
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
		
		// verificamos q el c??d de recinto sea correcto
		if ( !recintoService.findById(recinto).isPresent() ) {
			return new ResponseEntity<String>("Error. C??digo de recinto inv??lido", HttpStatus.BAD_REQUEST);
		}

		// armamos la fecha inicial
		LocalDateTime fechaInicioProceso = this.fechaStringToDate(fechaInicial + " 00:00:00");
		LOGGER.info("fechaInicioProceso: " + fechaInicioProceso);

		// armamos la fecha final
		LocalDateTime fechaFinalProceso = this.fechaStringToDate(fechaFinal + " 23:59:59");
		LOGGER.info("fechaFinalProceso: " + fechaFinalProceso);
		
		// realizamos la b??squeda de acuerdo al recinto
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
			return new ResponseEntity<String>("Error. C??digo de recinto sin tratamiento", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<List<PesajeRespuestaDTO>>(pesajesRespuesta, HttpStatus.OK);
	}
	
	@GetMapping(value = "/imprimirBoleta/{gestion}/{codPesaje}/{recintoCod}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<?> imprimirBoleta(
			@PathVariable("gestion") BigInteger gestion,
			@PathVariable("codPesaje") BigInteger codPesaje,
			@PathVariable("recintoCod") String recintoCod) {
		
		byte[] data = null;
		
		Recinto recinto = new Recinto();
		recinto = this.recintoService.findById(recintoCod).get();
		
		switch (recintoCod) {
		case "BER01": {
			com.albo.ber.model.PesajePK pesajePk = new com.albo.ber.model.PesajePK(gestion, codPesaje);
			Optional<com.albo.ber.model.Pesaje> psj = this.berService.findById(pesajePk);
			
			if ( psj.isEmpty() ) {
				return new ResponseEntity<String>("Error. El registro de pesaje no existe", HttpStatus.BAD_REQUEST);
			}
			
			data = this.boletaService.generarBoletaNueva(recinto.getNombre(), 
					Integer.valueOf(codPesaje.toString()), psj.get().getPsjFecha(), 
					psj.get().getPsjPeso(),	psj.get().getPsjPlaca());
			break;
		}
		case "CHB01": {
			com.albo.chb.model.PesajePK pesajePk = new com.albo.chb.model.PesajePK(gestion, codPesaje);
			Optional<com.albo.chb.model.Pesaje> psj = this.chbService.findById(pesajePk);
			
			if ( psj.isEmpty() ) {
				return new ResponseEntity<String>("Error. El registro de pesaje no existe", HttpStatus.BAD_REQUEST);
			}
			
			data = this.boletaService.generarBoletaNueva(recinto.getNombre(), 
					Integer.valueOf(codPesaje.toString()), psj.get().getPsjFecha(), 
					psj.get().getPsjPeso(),	psj.get().getPsjPlaca());
			break;
		}
		case "PAM01": {
			com.albo.pam.model.PesajePK pesajePk = new com.albo.pam.model.PesajePK(gestion, codPesaje);
			Optional<com.albo.pam.model.Pesaje> psj = this.pamService.findById(pesajePk);
			
			if ( psj.isEmpty() ) {
				return new ResponseEntity<String>("Error. El registro de pesaje no existe", HttpStatus.BAD_REQUEST);
			}
			
			data = this.boletaService.generarBoletaNueva(recinto.getNombre(), 
					Integer.valueOf(codPesaje.toString()), psj.get().getPsjFecha(), 
					psj.get().getPsjPeso(),	psj.get().getPsjPlaca());
			break;
		}
		case "PSG01": {
			com.albo.psg.model.PesajePK pesajePk = new com.albo.psg.model.PesajePK(gestion, codPesaje);
			Optional<com.albo.psg.model.Pesaje> psj = this.psgService.findById(pesajePk);
			
			if ( psj.isEmpty() ) {
				return new ResponseEntity<String>("Error. El registro de pesaje no existe", HttpStatus.BAD_REQUEST);
			}
			
			data = this.boletaService.generarBoletaNueva(recinto.getNombre(), 
					Integer.valueOf(codPesaje.toString()), psj.get().getPsjFecha(), 
					psj.get().getPsjPeso(),	psj.get().getPsjPlaca());
			break;
		}
		case "TAM01": {
			com.albo.tam.model.PesajePK pesajePk = new com.albo.tam.model.PesajePK(gestion, codPesaje);
			Optional<com.albo.tam.model.Pesaje> psj = this.tamService.findById(pesajePk);
			
			if ( psj.isEmpty() ) {
				return new ResponseEntity<String>("Error. El registro de pesaje no existe", HttpStatus.BAD_REQUEST);
			}
			
			data = this.boletaService.generarBoletaNueva(recinto.getNombre(), 
					Integer.valueOf(codPesaje.toString()), psj.get().getPsjFecha(), 
					psj.get().getPsjPeso(),	psj.get().getPsjPlaca());
			break;
		}
		case "VIL01": {
			com.albo.vil.model.PesajePK pesajePk = new com.albo.vil.model.PesajePK(gestion, codPesaje);
			Optional<com.albo.vil.model.Pesaje> psj = this.vilService.findById(pesajePk);
			
			if ( psj.isEmpty() ) {
				return new ResponseEntity<String>("Error. El registro de pesaje no existe", HttpStatus.BAD_REQUEST);
			}
			
			data = this.boletaService.generarBoletaNueva(recinto.getNombre(), 
					Integer.valueOf(codPesaje.toString()), psj.get().getPsjFecha(), 
					psj.get().getPsjPeso(),	psj.get().getPsjPlaca());
			break;
		}
		case "SCZ07": {
			com.albo.war.model.PesajePK pesajePk = new com.albo.war.model.PesajePK(gestion, codPesaje);
			Optional<com.albo.war.model.Pesaje> psj = this.warService.findById(pesajePk);
			
			if ( psj.isEmpty() ) {
				return new ResponseEntity<String>("Error. El registro de pesaje no existe", HttpStatus.BAD_REQUEST);
			}
			
			data = this.boletaService.generarBoletaNueva(recinto.getNombre(), 
					Integer.valueOf(codPesaje.toString()), psj.get().getPsjFecha(), 
					psj.get().getPsjPeso(),	psj.get().getPsjPlaca());
			break;
		}
		case "YAC01": {
			com.albo.yac.model.PesajePK pesajePk = new com.albo.yac.model.PesajePK(gestion, codPesaje);
			Optional<com.albo.yac.model.Pesaje> psj = this.yacService.findById(pesajePk);
			
			if ( psj.isEmpty() ) {
				return new ResponseEntity<String>("Error. El registro de pesaje no existe", HttpStatus.BAD_REQUEST);
			}
			
			data = this.boletaService.generarBoletaNueva(recinto.getNombre(), 
					Integer.valueOf(codPesaje.toString()), psj.get().getPsjFecha(), 
					psj.get().getPsjPeso(),	psj.get().getPsjPlaca());
			break;
		}
		default:
			return new ResponseEntity<String>("Error. C??digo de recinto sin tratamiento", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
		
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
			pesajeRespuesta.setFecha(p.getPsjFecha());
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
