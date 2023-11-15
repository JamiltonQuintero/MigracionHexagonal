package com.migracion.hexagonal.solucionproblema.servicio;

import com.migracion.hexagonal.solucionproblema.modelo.dto.RespuestaFinalRequest;
import com.migracion.hexagonal.solucionproblema.modelo.dto.SugerenciaProblemaIADto;

public interface RecomendacionProblema {

    SugerenciaProblemaIADto obtenerRecomendacion(RespuestaFinalRequest boardClientRequest);

}
