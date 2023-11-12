package com.migracion.hexagonal.problema.entity;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FechaIngreso {

    private final LocalDateTime valor;

    public FechaIngreso(LocalDateTime valor) {
        if (valor == null) {
            throw new IllegalArgumentException("Tipo Producto no puede ser vacio");
        }
        this.valor = valor;
    }

}
