package com.migracion.hexagonal.problema.dto;

import com.migracion.hexagonal.problema.enums.GeneroEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProblemaComando {

    private String descripcion;
    private byte edadCliente;
    private GeneroEnum generoCliente;
    private String tipo;

}
