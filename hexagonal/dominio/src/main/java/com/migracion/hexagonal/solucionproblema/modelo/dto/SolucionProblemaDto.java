package com.migracion.hexagonal.solucionproblema.modelo.dto;

import com.migracion.hexagonal.problema.modelo.enums.GeneroEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class SolucionProblemaDto {

    private String solucionComponenteQuimico;
    private String solucionRutina;
    private String urlAudio;
    private String idsProductos;
    private String descripcion;
    private byte edadCliente;
    private GeneroEnum generoCliente;
    private String tipo;

}
