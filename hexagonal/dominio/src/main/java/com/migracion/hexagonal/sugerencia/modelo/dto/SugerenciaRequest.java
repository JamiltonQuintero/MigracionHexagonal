package com.migracion.hexagonal.sugerencia.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class SugerenciaRequest {

    private String solucionComponenteQuimico;
    private String solucionRutina;
    private String urlAudio;
    private String idsProductos;
    private Long problemaId;

}
