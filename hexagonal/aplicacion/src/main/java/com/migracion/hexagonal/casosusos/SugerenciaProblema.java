package com.migracion.hexagonal.casosusos;


import com.migracion.hexagonal.sugerencia.modelo.dto.RespuestaFinalRequest;
import com.migracion.hexagonal.sugerencia.modelo.dto.SugerenciaResponse;

public interface SugerenciaProblema {

    SugerenciaResponse obtenerRecomendacionYSugerencia(RespuestaFinalRequest request);


}
