package com.migracion.hexagonal.sugerencia.rest.controller;

import com.migracion.hexagonal.casosusos.SugerenciaProblema;
import com.migracion.hexagonal.sugerencia.modelo.dto.SugerenciaRequest;
import com.migracion.hexagonal.sugerencia.modelo.dto.SugerenciaResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sugerencias")
public class SugerenciaController {

	private final SugerenciaProblema sugerenciaProblema;

	public SugerenciaController(SugerenciaProblema sugerenciaProblema) {
		this.sugerenciaProblema = sugerenciaProblema;
	}

	@PostMapping("/productos")
	public SugerenciaResponse getProductIdsAndSuggestion(@RequestBody SugerenciaRequest request) {
		return this.sugerenciaProblema.obtenerRecomendacionYSugerencia(request);
	}

}
