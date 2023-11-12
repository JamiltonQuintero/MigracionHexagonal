package com.migracion.hexagonal.sugerencia.entity;

import lombok.Getter;

@Getter
public class ProblemaId {

    private final Long valor;

    public ProblemaId(Long valor) {
        if (valor == null ) {
            throw new IllegalArgumentException("Rutina no puede ser vacio");
        }
        this.valor = valor;
    }

}
