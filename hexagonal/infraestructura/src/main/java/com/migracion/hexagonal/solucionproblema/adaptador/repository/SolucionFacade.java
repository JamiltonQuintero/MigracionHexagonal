package com.migracion.hexagonal.solucionproblema.adaptador.repository;

import com.migracion.hexagonal.problema.modelo.dto.ProblemaRequest;
import com.migracion.hexagonal.problema.puerto.Problema;
import com.migracion.hexagonal.solucionproblema.modelo.dto.SolucionProblemaDto;
import com.migracion.hexagonal.solucionproblema.puerto.SolucionPersistencia;
import com.migracion.hexagonal.sugerencia.modelo.dto.SugerenciaRequest;
import com.migracion.hexagonal.sugerencia.puerto.Sugerencia;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SolucionFacade implements SolucionPersistencia {

    private final Sugerencia sugerencia;
    private final Problema problema;
    public SolucionFacade(Sugerencia sugerencia, Problema problema) {
        this.sugerencia = sugerencia;
        this.problema = problema;
    }

    @Override
    @Async
    public void guardarSolucionProblema(SolucionProblemaDto solucionProblema) {
        var problema = this.problema.crear(solucionProblema);

        problema.ifPresent(problemaDto -> this.sugerencia.crear(SugerenciaRequest.builder()
                .solucionComponenteQuimico(solucionProblema.getSolucionComponenteQuimico())
                .solucionRutina(solucionProblema.getSolucionRutina())
                .idsProductos(solucionProblema.getIdsProductos())
                .problemaId(problemaDto.getId())
                .build()));
    }

    @Async
    public void guardarSolucionProblemaLuegoLuegoDeFallback(SolucionProblemaDto solucionProblema) {
        var problema = this.problema.crear(solucionProblema);

        problema.ifPresent(problemaDto -> this.sugerencia.crear(SugerenciaRequest.builder()
                .solucionComponenteQuimico(solucionProblema.getSolucionComponenteQuimico())
                .solucionRutina(solucionProblema.getSolucionRutina())
                .idsProductos(solucionProblema.getIdsProductos())
                .problemaId(problemaDto.getId())
                .build()));
    }

}
