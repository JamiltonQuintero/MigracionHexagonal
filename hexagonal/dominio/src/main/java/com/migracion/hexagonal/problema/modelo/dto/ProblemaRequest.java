package com.migracion.hexagonal.problema.modelo.dto;

import com.migracion.hexagonal.problema.modelo.enums.GeneroEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProblemaRequest {

    private String descripcion;
    private byte edadCliente;
    private GeneroEnum generoCliente;
    private String tipo;

}
