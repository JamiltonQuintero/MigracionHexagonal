package com.migracion.hexagonal.problema.modelo.dto;

import com.migracion.hexagonal.problema.modelo.enums.GeneroEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProblemaDto {

    private Long id;
    private String descripcion;
    private byte edadCliente;
    private GeneroEnum generoCliente;
    private String tipo;
    private LocalDateTime fechaIngreso;

}
