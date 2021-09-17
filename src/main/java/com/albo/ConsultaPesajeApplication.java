package com.albo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//INICIO entorno desarrollo
@SpringBootApplication
public class ConsultaPesajeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaPesajeApplication.class, args);
	}

}
//FIN entorno desarrollo


//INICIO despliege
//@SpringBootApplication
//public class ConsultaPesajeApplication extends SpringBootServletInitializer {
//
//	public static void main(String[] args) {
//		SpringApplication.run(ConsultaPesajeApplication.class, args);
//	}
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(ConsultaPesajeApplication.class);
//	}
//}
//FIN despliege
