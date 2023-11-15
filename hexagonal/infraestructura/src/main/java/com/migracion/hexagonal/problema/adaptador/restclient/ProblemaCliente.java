package com.migracion.hexagonal.problema.adaptador.restclient;

import com.migracion.hexagonal.problema.modelo.dto.ProblemaDto;
import com.migracion.hexagonal.problema.modelo.dto.ProblemaRequest;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${problema.name}", url = "${problema.url}")
@Retry(name = "problema")
public interface ProblemaCliente {

    @PostMapping()
    ProblemaDto guardar(@RequestBody ProblemaRequest problema);

}
