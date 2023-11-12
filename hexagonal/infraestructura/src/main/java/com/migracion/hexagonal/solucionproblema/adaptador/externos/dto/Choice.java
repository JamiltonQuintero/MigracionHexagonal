package com.migracion.hexagonal.solucionproblema.adaptador.externos.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Choice implements Serializable {
    private Integer index;
    private String text;
    private String finishReason;
}