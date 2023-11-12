package com.migracion.hexagonal.sugerencia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class SugerenciaComando {

    private String solucionComponenteQuimico;
    private String solucionRutina;
    private String urlAudio;
    private String idsProductos;
    private Long problemaId;

}
