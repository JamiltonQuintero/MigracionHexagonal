package com.migracion.hexagonal.adaptador.externos;

import com.migracion.hexagonal.adaptador.externos.dto.SolicitudGpt;
import com.migracion.hexagonal.adaptador.externos.dto.RespuestaGpt;
import feign.HeaderMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

public interface OpenIACliente {

    @RequestMapping(method = RequestMethod.GET, value = "/stores")
    RespuestaGpt obterRecomendacionGpt(@HeaderMap Map<String, Object> headers, @RequestBody SolicitudGpt solicitudGpt);

}
