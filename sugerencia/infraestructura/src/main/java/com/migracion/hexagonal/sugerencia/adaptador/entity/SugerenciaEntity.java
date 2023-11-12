package com.migracion.hexagonal.sugerencia.adaptador.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



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

    @Column(name = "sol_comp_quimico", columnDefinition = "text")
    private String solucionComponenteQuimico;

    @Column(name = "solucion_rutina", columnDefinition = "text")
    private String solucionRutina;

    @Column(name = "url_audio", columnDefinition = "varchar(255)")
    private String urlAudio;

    @Column(name = "ids_productos", columnDefinition = "varchar(255)")
    private String idsProductos;

    @Column(name = "id_problema", columnDefinition = "integer")
    private Long problemaId;

}
