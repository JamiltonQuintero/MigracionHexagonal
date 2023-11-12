package com.migracion.hexagonal.solucionproblema.adaptador.externos;

import com.migracion.hexagonal.solucionproblema.adaptador.externos.dto.SolicitudGpt;
import com.migracion.hexagonal.solucionproblema.adaptador.externos.restclient.OpenIACliente;
import com.migracion.hexagonal.solucionproblema.adaptador.externos.utils.ConfigGpt;
import com.migracion.hexagonal.sugerencia.puerto.SugerenciaIA;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SugerenciaOpenIA implements SugerenciaIA {

    public static final int PRIMER_ELEMENTO = 0;
    private final OpenIACliente openIACliente;
    @Value("${openai.api-key}")
    private String apiKey;
    public SugerenciaOpenIA(OpenIACliente openIACliente) {
        this.openIACliente = openIACliente;
    }

    public String obtenerRespuestaIA(String problema) {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", ConfigGpt.MEDIA_TYPE);
        headerMap.put(ConfigGpt.AUTHORIZATION, ConfigGpt.BEARER + apiKey);

        var request = new SolicitudGpt(
                ConfigGpt.MODELO,
                problema,
                ConfigGpt.TEMPERATURA,
                ConfigGpt.TOKEN_MAXIMO,
                ConfigGpt.TOP_P);

        return this.openIACliente.obterRecomendacionGpt(headerMap, request)
                .getChoices().get(PRIMER_ELEMENTO).getText();
    }

}
