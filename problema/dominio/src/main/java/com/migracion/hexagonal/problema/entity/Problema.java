package com.migracion.hexagonal.problema.entity;

import com.migracion.hexagonal.problema.enums.GeneroEnum;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class Problema {

    private Long id;
    private Descripcion descripcion;
    private EdadCliente edadCliente;
    private GeneroCliente generoCliente;
    private TipoProducto tipoProducto;
    private FechaIngreso fechaIngreso;

    public Problema(
            String problema,
            byte edadCliente,
            GeneroEnum generoCliente,
            String tipo) {
        this.descripcion = new Descripcion(problema);
        this.edadCliente = new EdadCliente(edadCliente);
        this.generoCliente = new GeneroCliente(generoCliente);
        this.tipoProducto = new TipoProducto(tipo);
        this.fechaIngreso = new FechaIngreso(LocalDateTime.now());
    }

    public Problema(
            Long id,
            String problema,
            byte edadCliente,
            GeneroEnum generoCliente,
            String tipo,
            LocalDateTime fechaIngreso) {
        this.descripcion = new Descripcion(problema);
        this.edadCliente = new EdadCliente(edadCliente);
        this.generoCliente = new GeneroCliente(generoCliente);
        this.tipoProducto = new TipoProducto(tipo);
        this.fechaIngreso = new FechaIngreso(fechaIngreso);
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion.getValor();
    }

    public byte getEdadCliente() {
        return edadCliente.getValor();
    }

    public GeneroEnum getGeneroCliente() {
        return generoCliente.getValor();
    }


    public String getTipoProducto() {
        return tipoProducto.getValor();
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso.getValor();
    }

}
