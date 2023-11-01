package com.migracion.hexagonal.problema.modelo.entity;

import com.migracion.hexagonal.problema.modelo.enums.GeneroEnum;
import lombok.Getter;

@Getter
public class GeneroCliente {

    private final GeneroEnum valor;

    public GeneroCliente(GeneroEnum valor) {
        if (valor == null) {
            throw new IllegalArgumentException("Genero no puede ser vacio");
        }
        this.valor = valor;
    }

}
