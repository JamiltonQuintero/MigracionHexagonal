package com.migracion.hexagonal.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SugerenciaProductoDto {

    private String sugerenciaCliente;
    private String urlAudio;
    private List<Integer> idsProductosRecomendados;

}
