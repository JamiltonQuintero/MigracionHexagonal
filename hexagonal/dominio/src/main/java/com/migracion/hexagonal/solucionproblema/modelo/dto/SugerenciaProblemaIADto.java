package com.migracion.hexagonal.solucionproblema.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class SugerenciaProblemaIADto {

    private String rutinaSugeridaCliente;
    private String componentesSugeridosCliente;
    private String tipoProblema;

}
