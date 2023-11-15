package com.migracion.hexagonal.problema.adaptador.restclient;

import com.migracion.hexagonal.problema.modelo.dto.ProblemaDto;
import com.migracion.hexagonal.problema.modelo.dto.ProblemaRequest;
import com.migracion.hexagonal.problema.puerto.Problema;
import com.migracion.hexagonal.solucionproblema.modelo.dto.SolucionProblemaDto;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;


@Service
@Slf4j
public class ProblemaAdapter implements Problema {
    private static final String RESILIENCE4J_INSTANCE_NAME = "problema";
    private static final String FALLBACK_METHOD = "guardarProblemaEnMemoria";
    private Queue<SolucionProblemaDto> colaDeProblemas = new LinkedList<>();
    private final ProblemaCliente problemaCliente;
    private final CircuitBreaker circuitBreakerInstance;

    public ProblemaAdapter(ProblemaCliente problemaCliente, CircuitBreaker circuitBreakerInstance) {
        this.problemaCliente = problemaCliente;
        this.circuitBreakerInstance = circuitBreakerInstance;
    }

    @Override
    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    public Optional<ProblemaDto> crear(SolucionProblemaDto solucionProblema) {
        ProblemaDto resultado = this.problemaCliente.guardar(ProblemaRequest.builder()
                .descripcion(solucionProblema.getDescripcion())
                .edadCliente(solucionProblema.getEdadCliente())
                .generoCliente(solucionProblema.getGeneroCliente())
                .tipo(solucionProblema.getTipo())
                .build());
        return Optional.ofNullable(resultado);
    }

    public Optional<ProblemaDto> guardarProblemaEnMemoria(SolucionProblemaDto solucionProblema, Exception exception) {
        colaDeProblemas.add(solucionProblema);
        return Optional.empty();
    }

    @PostConstruct
    public void init() {
        circuitBreakerInstance.getEventPublisher()
                .onStateTransition(event -> {
                    System.out.println(event);
                    if (event.getStateTransition().getToState() == CircuitBreaker.State.CLOSED) {
                        procesarColaDeProblemas();
                    }
                });
    }

    private void procesarColaDeProblemas() {
        while (!colaDeProblemas.isEmpty()) {
            SolucionProblemaDto problema = colaDeProblemas.poll();
            System.out.println("NUEVAMENTE ARRIBA");
            System.out.println(problema);
        }
    }

}
