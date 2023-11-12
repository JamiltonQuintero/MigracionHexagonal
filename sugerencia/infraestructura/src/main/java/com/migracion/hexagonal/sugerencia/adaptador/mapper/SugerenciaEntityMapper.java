package com.migracion.hexagonal.sugerencia.adaptador.mapper;

import com.migracion.hexagonal.sugerencia.adaptador.entity.SugerenciaEntity;
import com.migracion.hexagonal.sugerencia.entity.Sugerencia;

public class SugerenciaEntityMapper {

    public static SugerenciaEntity toEntidad(Sugerencia sugerencia){
        return SugerenciaEntity.builder()
                .id(sugerencia.getId())
                .solucionComponenteQuimico(sugerencia.getSolucionComponenteQuimico())
                .solucionRutina(sugerencia.getSolucionRutina())
                .urlAudio(sugerencia.getUrlAudio())
                .idsProductos(sugerencia.getIdsProductos())
                .problemaId(sugerencia.getProblemaId())
                .build();
    }

    public static SugerenciaEntity toEntidadCrear(Sugerencia sugerencia){
        return SugerenciaEntity.builder()
                .solucionComponenteQuimico(sugerencia.getSolucionComponenteQuimico())
                .solucionRutina(sugerencia.getSolucionRutina())
                .urlAudio(sugerencia.getUrlAudio())
                .idsProductos(sugerencia.getIdsProductos())
                .problemaId(sugerencia.getProblemaId())
                .build();
    }

}
