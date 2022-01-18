package com.albo.consulta.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.albo.consulta.service.IBoletaService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class BoletaServiceimpl implements IBoletaService {

	@Override
	public byte[] generarBoleta(String pesoBruto, String pesoTara, String pesoNeto, String placa, String obs,
			String nombreRecinto, String nombreUsuario) {
		byte[] data = null;
		try {
			File file = new ClassPathResource("/reports/boletaReport_original.jasper").getFile();
			Map<String, Object> map = new HashMap<>();
			map.put("recinto", nombreRecinto);
			map.put("usuario", nombreUsuario);
			map.put("pesoBruto", pesoBruto);
			map.put("pesoTara", pesoTara);
			map.put("pesoNeto", pesoNeto);
			map.put("placa", placa);
			map.put("obs", obs);
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), map);
			data = JasperExportManager.exportReportToPdf(print);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public byte[] generarBoletaNueva(String nombreRecinto, Integer codPesaje, LocalDateTime fecha, BigDecimal pesoBruto,
			String placa) {
		byte[] data = null;
		try {
			File file = new ClassPathResource("/reports/boletaPesaje.jasper").getFile();
			Map<String, Object> map = new HashMap<>();
			map.put("recinto", nombreRecinto);
			map.put("codPesaje", codPesaje);
			map.put("fecha", fecha);
			map.put("pesoBruto", pesoBruto);
			map.put("placa", placa);
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), map);
			data = JasperExportManager.exportReportToPdf(print);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
