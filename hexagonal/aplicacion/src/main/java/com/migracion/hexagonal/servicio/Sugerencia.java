package com.migracion.hexagonal.servicio;

import com.migracion.hexagonal.casosusos.SugerenciaProducto;
import com.migracion.hexagonal.modelo.dto.SolicitudProblemaDto;
import com.migracion.hexagonal.modelo.dto.SugerenciaProductoDto;
import com.migracion.hexagonal.modelo.dto.SugerenciaProblemaIADto;
import com.migracion.hexagonal.puerto.AlmacenadorAudio;
import com.migracion.hexagonal.puerto.GeneradorAudio;

import java.io.InputStream;
import java.util.List;

public class Sugerencia implements SugerenciaProducto {
    public static final String MESSAGE_WHEN_TAKE_PRODUCTS = " Te dejaremos estos productos como recomendacion a continuación";
    public static final String MESSAGE_WHEN_DONT_TAKE_PRODUCTS = "No tenemos productos para recomendarte pero podemos darte el siguiente consejo: ";
    //private final LuxeneProductService luxeneProductService;
    private final AlmacenadorAudio almacenadorAudio;
    private final GeneradorAudio generadorAudio;
    private final RecomendacionProblema recomendacionProblema;

    public Sugerencia(AlmacenadorAudio almacenadorAudio, GeneradorAudio generadorAudio, RecomendacionProblema recomendacionProblema) {
        this.almacenadorAudio = almacenadorAudio;
        this.generadorAudio = generadorAudio;
        this.recomendacionProblema = recomendacionProblema;
    }


    //private final ClientProblemRepository clientProblemRepository;

    @Override
    public SugerenciaProductoDto obtenerRecomendacionYSugerencia(SolicitudProblemaDto request) {

        SugerenciaProblemaIADto suggestion = recomendacionProblema.obtenerRecomendacion(request);

      clientProblemRepository.save(new ClientProblem(null, request.getMensaje(), request.getEdadCliente(),request.getGeneroCliente(),
                suggestion.getComponentesSugeridosCliente(), suggestion.getRutinaSugeridaCliente(), suggestion.getMarcaPrincipal()));

        List<Integer> productIds = luxeneProductService.searchBestProductsAcordingToSuggestion(request.getMensaje(),suggestion);

        String finalSuggestioToClient = cleanTextOfSpecialCharacters(suggestion.getRutinaSugeridaCliente());

        String finalSuggestionToAudio = getFinalSuggestion(suggestion, productIds);
        InputStream audioSuggestion = generadorAudio.generarAudioConRecomendacion(finalSuggestionToAudio);
        String audioUrl = almacenadorAudio.guardarAudio(audioSuggestion);

        return new SugerenciaProductoDto(finalSuggestioToClient, audioUrl, productIds);

    }

    private static String getFinalSuggestion(SugerenciaProblemaIADto suggestion, List<Integer> productIds) {
        String finalSuggestion = "";

        if(!productIds.isEmpty()){
            finalSuggestion = suggestion.getRutinaSugeridaCliente().concat(MESSAGE_WHEN_TAKE_PRODUCTS);
        } else {
            finalSuggestion = MESSAGE_WHEN_DONT_TAKE_PRODUCTS.concat(suggestion.getRutinaSugeridaCliente());
        }
        return finalSuggestion;
    }

}
