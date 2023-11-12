package com.migracion.hexagonal.problema.rest.controller.comando;

import com.migracion.hexagonal.problema.dto.ProblemaComando;
import com.migracion.hexagonal.problema.dto.ProblemaDto;
import com.migracion.hexagonal.problema.servicio.ProblemaCreacion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/problemas")
public class ProblemaComandoController {

	private final ProblemaCreacion problemaCreacion;

	public ProblemaComandoController(ProblemaCreacion problemaCreacion) {
		this.problemaCreacion = problemaCreacion;
	}

	@PostMapping()
	public ResponseEntity<ProblemaDto> getProductIdsAndSuggestion(@RequestBody ProblemaComando comando) {
		var problema = this.problemaCreacion.crear(comando);
		return new ResponseEntity<>(problema, HttpStatus.OK);
	}

}
