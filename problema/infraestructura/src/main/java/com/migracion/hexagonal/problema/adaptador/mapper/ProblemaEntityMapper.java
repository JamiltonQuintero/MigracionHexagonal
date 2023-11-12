package com.migracion.hexagonal.problema.adaptador.mapper;

import com.migracion.hexagonal.problema.adaptador.entity.ProblemaEntity;
import com.migracion.hexagonal.problema.entity.Problema;

public class ProblemaEntityMapper {

    public static ProblemaEntity toEntidad(Problema problema){
        return ProblemaEntity.builder()
                .id(problema.getId())
                .descripcion(problema.getDescripcion())
                .edadCliente(problema.getEdadCliente())
                .generoCliente(problema.getGeneroCliente())
                .tipo(problema.getTipoProducto())
                .fechaIngreso(problema.getFechaIngreso())
                .build();
    }

    public static ProblemaEntity toEntidadCrear(Problema problema){
        return ProblemaEntity.builder()
                .descripcion(problema.getDescripcion())
                .edadCliente(problema.getEdadCliente())
                .generoCliente(problema.getGeneroCliente())
                .tipo(problema.getTipoProducto())
                .fechaIngreso(problema.getFechaIngreso())
                .build();
    }

    public static Problema toDominio(ProblemaEntity entity){
        return new Problema(
                entity.getId(),
                entity.getDescripcion(),
                entity.getEdadCliente(),
                entity.getGeneroCliente(),
                entity.getTipo(),
                entity.getFechaIngreso());
    }

}
