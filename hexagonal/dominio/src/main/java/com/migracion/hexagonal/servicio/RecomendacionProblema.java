package com.migracion.hexagonal.servicio;

import com.migracion.hexagonal.modelo.dto.SolicitudProblemaDto;
import com.migracion.hexagonal.modelo.dto.SugerenciaProblemaIADto;

public interface RecomendacionProblema {

    SugerenciaProblemaIADto obtenerRecomendacion(SolicitudProblemaDto boardClientRequest);

}
