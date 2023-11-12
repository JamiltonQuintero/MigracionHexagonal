package com.migracion.hexagonal.problema.mapper;


import com.migracion.hexagonal.problema.dto.ProblemaComando;
import com.migracion.hexagonal.problema.dto.ProblemaDto;
import com.migracion.hexagonal.problema.entity.Problema;

public class ProblemaDtoMapper {

    public static Problema toDominio(ProblemaComando problemaComando) {
        return new Problema(problemaComando.getDescripcion(),
                problemaComando.getEdadCliente(),
                problemaComando.getGeneroCliente(),
                problemaComando.getTipo());
    }

    public static ProblemaDto toDto(Problema problema) {
        return new ProblemaDto(
                problema.getId(), 
                problema.getDescripcion(),
                problema.getEdadCliente(),
                problema.getGeneroCliente(),
                problema.getTipoProducto(),
                problema.getFechaIngreso());
    }

}
