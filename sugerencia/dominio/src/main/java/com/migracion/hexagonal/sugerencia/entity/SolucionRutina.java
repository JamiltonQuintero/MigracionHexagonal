package com.migracion.hexagonal.sugerencia.entity;

import lombok.Getter;

@Getter
public class SolucionRutina {

    private final String valor;

    public SolucionRutina(String valor) {
        if (valor == null || valor.isEmpty()) {
            throw new IllegalArgumentException("Rutina no puede ser vacio");
        }
        this.valor = valor;
    }

}
