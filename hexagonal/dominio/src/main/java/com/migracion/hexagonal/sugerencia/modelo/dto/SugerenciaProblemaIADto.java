package com.migracion.hexagonal.sugerencia.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SugerenciaProblemaIADto {

    private String rutinaSugeridaCliente;
    private String componentesSugeridosCliente;
    private String tipoProblema;

}
