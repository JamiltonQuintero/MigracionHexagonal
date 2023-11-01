package com.migracion.hexagonal.casosusos;


import com.migracion.hexagonal.sugerencia.modelo.dto.SugerenciaRequest;
import com.migracion.hexagonal.sugerencia.modelo.dto.SugerenciaResponse;

public interface SugerenciaProblema {

    SugerenciaResponse obtenerRecomendacionYSugerencia(SugerenciaRequest request);


}
