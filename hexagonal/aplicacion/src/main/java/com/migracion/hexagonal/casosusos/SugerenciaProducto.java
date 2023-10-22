package com.migracion.hexagonal.casosusos;

import com.migracion.hexagonal.modelo.dto.SolicitudProblemaDto;
import com.migracion.hexagonal.modelo.dto.SugerenciaProductoDto;

public interface SugerenciaProducto {

    SugerenciaProductoDto obtenerRecomendacionYSugerencia(SolicitudProblemaDto request);


}
