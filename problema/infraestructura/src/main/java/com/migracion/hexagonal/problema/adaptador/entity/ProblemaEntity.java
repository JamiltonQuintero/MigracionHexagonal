package com.migracion.hexagonal.problema.adaptador.entity;


import com.migracion.hexagonal.problema.enums.GeneroEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "problema")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProblemaEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "descripcion", columnDefinition = "text")
    private String descripcion;

    @Column(name = "edad_cliente")
    private byte edadCliente;

    @Column(name = "genero_cliente")
    private GeneroEnum generoCliente;

    @Column(name = "tipo", length = 100)
    private String tipo;

    @Column(name = "fecha_ingreso", length = 100)
    private LocalDateTime fechaIngreso;

}
