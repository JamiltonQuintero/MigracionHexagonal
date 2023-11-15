package com.migracion.hexagonal.casosusos;


import com.migracion.hexagonal.solucionproblema.modelo.dto.RespuestaFinalRequest;
import com.migracion.hexagonal.solucionproblema.modelo.dto.SugerenciaResponse;

public interface SugerenciaProblema {

    SugerenciaResponse obtenerRecomendacionYSugerencia(RespuestaFinalRequest request);


}
