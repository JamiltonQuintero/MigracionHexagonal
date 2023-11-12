package com.migracion.hexagonal.sugerencia.mapper;

import com.migracion.hexagonal.sugerencia.dto.SugerenciaComando;
import com.migracion.hexagonal.sugerencia.entity.Sugerencia;

public class SugerenciaDtoMapper {

    public static Sugerencia toDominio(SugerenciaComando sugerenciaComando) {
        return new Sugerencia(sugerenciaComando.getSolucionComponenteQuimico(),
                sugerenciaComando.getSolucionRutina(),
                sugerenciaComando.getUrlAudio(),
                sugerenciaComando.getIdsProductos(),
                sugerenciaComando.getProblemaId());
    }

}
