package com.migracion.hexagonal.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SolicitudProblemaDto {

    private char generoCliente;
    private byte edadCliente;
    private String mensaje;

}
