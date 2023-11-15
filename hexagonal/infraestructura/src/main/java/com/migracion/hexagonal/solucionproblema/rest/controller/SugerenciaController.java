package com.migracion.hexagonal.solucionproblema.rest.controller;

import com.migracion.hexagonal.casosusos.SugerenciaProblema;
import com.migracion.hexagonal.solucionproblema.modelo.dto.RespuestaFinalRequest;
import com.migracion.hexagonal.solucionproblema.modelo.dto.SugerenciaResponse;
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
	public SugerenciaResponse getProductIdsAndSuggestion(@RequestBody RespuestaFinalRequest request) {
		return this.sugerenciaProblema.obtenerRecomendacionYSugerencia(request);
	}

}
