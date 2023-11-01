package com.migracion.hexagonal.sugerencia.adaptador.entity;


import com.migracion.hexagonal.problema.adaptador.entity.ProblemaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sugerencia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SugerenciaEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "solucion_componente_quimico", columnDefinition = "text")
    private String solucionComponenteQuimico;

    @Column(name = "solucion_rutina", columnDefinition = "text")
    private String solucionRutina;

    @Column(name = "url_audio", columnDefinition = "text")
    private String urlAudio;

    @Column(name = "ids_productos", columnDefinition = "text")
    private String idsProductos;

    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    @JoinColumn(name = "problema_id", referencedColumnName = "id")
    private ProblemaEntity problema;

}
