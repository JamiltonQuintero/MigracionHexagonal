package com.migracion.hexagonal.problema.adaptador.entity;


import com.migracion.hexagonal.problema.modelo.enums.GeneroEnum;
import com.migracion.hexagonal.sugerencia.adaptador.entity.SugerenciaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

    @OneToOne(mappedBy = "problema", fetch = FetchType.LAZY)
    private SugerenciaEntity sugerencia;

}
