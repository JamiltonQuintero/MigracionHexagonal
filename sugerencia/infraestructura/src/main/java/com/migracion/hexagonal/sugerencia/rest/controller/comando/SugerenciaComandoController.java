package com.migracion.hexagonal.sugerencia.rest.controller.comando;

import com.migracion.hexagonal.sugerencia.dto.SugerenciaComando;
import com.migracion.hexagonal.sugerencia.servicio.SugerenciaCreacion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sugerencias")
public class SugerenciaComandoController {

	private final SugerenciaCreacion sugerenciaCreacion;

	public SugerenciaComandoController(SugerenciaCreacion sugerenciaCreacion) {
		this.sugerenciaCreacion = sugerenciaCreacion;
	}

	@PostMapping()
	public ResponseEntity<HttpStatus> registrar(@RequestBody SugerenciaComando comando) {
		this.sugerenciaCreacion.crear(comando);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
