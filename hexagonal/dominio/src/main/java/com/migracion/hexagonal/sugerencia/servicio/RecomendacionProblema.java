package com.migracion.hexagonal.sugerencia.servicio;

import com.migracion.hexagonal.sugerencia.modelo.dto.SugerenciaProblemaIADto;
import com.migracion.hexagonal.sugerencia.modelo.dto.SugerenciaRequest;

public interface RecomendacionProblema {

    SugerenciaProblemaIADto obtenerRecomendacion(SugerenciaRequest boardClientRequest);

}
