package com.migracion.hexagonal.solucionproblema.modelo.dto;

import com.migracion.hexagonal.problema.modelo.enums.GeneroEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RespuestaFinalRequest {

    private GeneroEnum generoCliente;
    private byte edadCliente;
    private String problema;

}
