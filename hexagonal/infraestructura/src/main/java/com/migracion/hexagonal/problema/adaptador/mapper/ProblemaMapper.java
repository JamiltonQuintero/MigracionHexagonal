package com.migracion.hexagonal.problema.adaptador.mapper;

import com.migracion.hexagonal.problema.adaptador.entity.ProblemaEntity;
import com.migracion.hexagonal.problema.modelo.entity.Problema;

public class ProblemaMapper {

    public static ProblemaEntity toEntidad(Problema problema){
        return ProblemaEntity.builder()
                .id(problema.getId())
                .descripcion(problema.getDescripcion())
                .edadCliente(problema.getEdadCliente())
                .generoCliente(problema.getGeneroCliente())
                .tipo(problema.getTipoProducto())
                .build();
    }

    public static ProblemaEntity toEntidadCrear(Problema problema){
        return ProblemaEntity.builder()
                .descripcion(problema.getDescripcion())
                .edadCliente(problema.getEdadCliente())
                .generoCliente(problema.getGeneroCliente())
                .tipo(problema.getTipoProducto())
                .build();
    }

    public static Problema toDominio(ProblemaEntity entity){
        return new Problema(
                entity.getId(),
                entity.getDescripcion(),
                entity.getEdadCliente(),
                entity.getGeneroCliente(),
                entity.getTipo());
    }

}
