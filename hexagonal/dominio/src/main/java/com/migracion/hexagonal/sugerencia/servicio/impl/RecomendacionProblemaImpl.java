package com.migracion.hexagonal.sugerencia.servicio.impl;

import com.migracion.hexagonal.sugerencia.modelo.dto.SugerenciaProblemaIADto;
import com.migracion.hexagonal.sugerencia.modelo.dto.RespuestaFinalRequest;
import com.migracion.hexagonal.sugerencia.puerto.SugerenciaIA;
import com.migracion.hexagonal.sugerencia.servicio.RecomendacionProblema;

import java.util.concurrent.CompletableFuture;

public class RecomendacionProblemaImpl implements RecomendacionProblema {

    public static final String MENSAJE_PREFIJO = "(Generar Recomendacion enfocada en productos de belleza y cuidado personal sin mencionar marcas especificas. Esta recomendacion debe estar dada para para una %s de %s años, la recomendacion debe ser muy optimizada y detallada para mejorar la situacion mencionada)";
    public static final String MENSAJE_BASE_TIPO_PRINCIPAL = "De estas opciones donde solo es posible una respuesta, A=Cuidado capilar,B=Cuidado corporal, C=Cuidado facial. P:Tengo mucha caspa y el cabello muy grasoso :A, P:Tengo muchos granos en la cara :C, P:Tengo muchos granos en la espalda :B, P:Tengo muchos granos en la cabeza :A, P:Se me cae mucho el pelo :A, P:%s:";
    public static final String MENSAJE_BASE_SUGERENCIA_COMPONENTES = "Como experta en %s, ¿podrías recomendarme algunos productos y componentes naturales o químicos que sean efectivos para tratar el siguiente problema: %s de %s de %s años? Preferiblemente, evitando mencionar marcas específicas pero proporcionando información detallada sobre los ingredientes activos que son beneficiosos para tratar este problema.";
    public static final String MENSAJE_BASE_SUGERENCIA_RUTINA = "Como experta en %s, ¿podrías recomendarme tips o una rutina diaria, semanal o mensual de %s para tratar el siguiente problema: %s de %s de %s años? Por favor, proporciona información detallada del paso a paso a seguir para mejorar esta situación, evitando mencionar productos y marcas específicas.";

    private final SugerenciaIA sugerenciaIA;

    public RecomendacionProblemaImpl(SugerenciaIA sugerenciaIA) {
        this.sugerenciaIA = sugerenciaIA;
    }

    @Override
    public SugerenciaProblemaIADto obtenerRecomendacion(RespuestaFinalRequest solicitudProblema){

        String marca = obtenerMarcaPrincipal(solicitudProblema);

        CompletableFuture<String> futuroSugerenciaRutina = CompletableFuture.supplyAsync(() -> obtenerSugerenciaRutina(solicitudProblema, marca));

        CompletableFuture<String> futuroSugerenciaComponente = CompletableFuture.supplyAsync(() -> obtenerComponentesSugerencia(solicitudProblema, marca));

        CompletableFuture<SugerenciaProblemaIADto> futuroCombinado = futuroSugerenciaRutina.thenCombine(futuroSugerenciaComponente, (rutina, componentes) ->
                new SugerenciaProblemaIADto(rutina, componentes, marca));

        return futuroCombinado.join();
    }

    private String obtenerMarcaPrincipal(RespuestaFinalRequest solicitudProblema) {
        String mensaje = String.format(MENSAJE_BASE_TIPO_PRINCIPAL, solicitudProblema.getProblema());
        return obtenerMarcaPrincipal(this.sugerenciaIA.obtenerRespuestaIA(mensaje));
    }

    private String obtenerComponentesSugerencia(RespuestaFinalRequest solicitudProblema, String marca) {
        String mensaje = obtenerComponentesSugerenciaBasadoEnEdadYGenero(solicitudProblema, marca);
        return this.sugerenciaIA.obtenerRespuestaIA(mensaje);
    }

    private String obtenerComponentesSugerenciaBasadoEnEdadYGenero(RespuestaFinalRequest solicitudProblema, String marca) {
        return String.format(MENSAJE_BASE_SUGERENCIA_COMPONENTES, marca, solicitudProblema.getProblema(), solicitudProblema.getGeneroCliente(), solicitudProblema.getEdadCliente());
    }

    private String obtenerSugerenciaRutina(RespuestaFinalRequest solicitudProblema, String marca) {
        String mensaje = obtenerRutinaSugerenciaBasadoEnEdadYGenero(solicitudProblema, marca);
        return this.sugerenciaIA.obtenerRespuestaIA(mensaje);
    }

    private String obtenerRutinaSugerenciaBasadoEnEdadYGenero(RespuestaFinalRequest solicitudProblema, String marca) {
        return String.format(MENSAJE_BASE_SUGERENCIA_RUTINA, marca, marca, solicitudProblema.getProblema(), solicitudProblema.getGeneroCliente(), solicitudProblema.getEdadCliente());
    }

    private static String obtenerMarcaPrincipal(String marca) {
        switch (marca) {
            case "A":
                return "cuidado capilar";
            case "B":
                return "cuidado corporal";
            case "C":
                return "cuidado facial";
            default:
                return "cuidado de la belleza";
        }
    }



}
