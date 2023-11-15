package com.migracion.hexagonal.sugerencia.adaptador.restclient;

import com.migracion.hexagonal.sugerencia.modelo.dto.SugerenciaRequest;
import com.migracion.hexagonal.sugerencia.puerto.Sugerencia;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class SugerenciaAdapter implements Sugerencia {

    private static final String RESILIENCE4J_INSTANCE_NAME = "sugerencia";
    private static final String FALLBACK_METHOD = "guardarEnMemoria";
    private final SugerenciaCliente sugerenciaCliente;

    public SugerenciaAdapter(SugerenciaCliente sugerenciaCliente) {
        this.sugerenciaCliente = sugerenciaCliente;
    }

    @Override
    @Async
    @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    public void crear(SugerenciaRequest sugerencia) {
        this.sugerenciaCliente.guardar(sugerencia);
    }

    public void guardarEnMemoria(SugerenciaRequest sugerencia, Exception e) {
        //this.sugerenciaCliente.guardar(sugerencia);
        log.info("GUARDANDO EN MEMORIA sugerencia", e);
    }

}
