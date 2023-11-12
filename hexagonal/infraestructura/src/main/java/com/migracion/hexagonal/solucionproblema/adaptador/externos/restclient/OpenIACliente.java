package com.migracion.hexagonal.solucionproblema.adaptador.externos.restclient;

import com.migracion.hexagonal.solucionproblema.adaptador.externos.dto.RespuestaGpt;
import com.migracion.hexagonal.solucionproblema.adaptador.externos.dto.SolicitudGpt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = "${feign.name.openaia}", url = "${feign.url.openaia}")
public interface OpenIACliente {

    @RequestMapping(method = RequestMethod.GET, value = "/stores")
    RespuestaGpt obterRecomendacionGpt(@RequestHeader Map<String, String> headerMap, @RequestBody SolicitudGpt solicitudGpt);

}
