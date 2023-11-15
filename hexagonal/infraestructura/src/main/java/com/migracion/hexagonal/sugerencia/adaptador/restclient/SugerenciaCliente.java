package com.migracion.hexagonal.sugerencia.adaptador.restclient;

import com.migracion.hexagonal.sugerencia.modelo.dto.SugerenciaRequest;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${sugerencia.name}", url = "${sugerencia.url}")
@Retry(name = "sugerencia")
public interface SugerenciaCliente {

    @PostMapping()
    void guardar(@RequestBody SugerenciaRequest sugerencia);

}
