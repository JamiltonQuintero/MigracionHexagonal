package com.migracion.hexagonal.sugerencia.modelo.dto;

import com.migracion.hexagonal.problema.modelo.enums.GeneroEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SugerenciaRequest {

    private GeneroEnum generoCliente;
    private byte edadCliente;
    private String problema;

}
