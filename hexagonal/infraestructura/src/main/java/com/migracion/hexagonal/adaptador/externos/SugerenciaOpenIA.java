package com.migracion.hexagonal.adaptador.externos;

import com.migracion.hexagonal.adaptador.externos.dto.SolicitudGpt;
import com.migracion.hexagonal.adaptador.externos.utils.ConfigGpt;
import com.migracion.hexagonal.puerto.SugerenciaIA;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

public class SugerenciaOpenIA implements SugerenciaIA {

    public static final int PRIMER_ELEMENTO = 0;
    private OpenIACliente openIACliente;
    private final String apiKey;
    public SugerenciaOpenIA(@Value("${openai.api-key}")String apiKey, OpenIACliente openIACliente) {
        this.apiKey = apiKey;
        this.openIACliente = openIACliente;
    }

    public String obtenerRespuestaIA(String problema) {
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("Content-Type", ConfigGpt.MEDIA_TYPE);
        headerMap.put(ConfigGpt.AUTHORIZATION, ConfigGpt.BEARER + apiKey);
        return this.openIACliente.obterRecomendacionGpt(headerMap, new SolicitudGpt(
                ConfigGpt.MODELO,
                problema,
                ConfigGpt.TEMPERATURA,
                ConfigGpt.TOKEN_MAXIMO,
                ConfigGpt.TOP_P))
                .getChoices().get(PRIMER_ELEMENTO).getText();
    }

}
