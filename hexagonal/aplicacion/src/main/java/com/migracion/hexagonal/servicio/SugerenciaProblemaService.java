package com.migracion.hexagonal.servicio;

import com.migracion.hexagonal.casosusos.SugerenciaProblema;
import com.migracion.hexagonal.problema.modelo.entity.Problema;
import com.migracion.hexagonal.problema.puerto.ProblemaRepository;
import com.migracion.hexagonal.sugerencia.modelo.dto.SugerenciaProblemaIADto;
import com.migracion.hexagonal.sugerencia.modelo.dto.SugerenciaRequest;
import com.migracion.hexagonal.sugerencia.modelo.dto.SugerenciaResponse;
import com.migracion.hexagonal.sugerencia.modelo.entity.Sugerencia;
import com.migracion.hexagonal.sugerencia.puerto.AlmacenadorAudio;
import com.migracion.hexagonal.sugerencia.puerto.GeneradorAudio;
import com.migracion.hexagonal.sugerencia.puerto.SugerenciaRepository;
import com.migracion.hexagonal.sugerencia.servicio.RecomendacionProblema;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SugerenciaProblemaService implements SugerenciaProblema {
    public static final String MENSAJE_EXISTEN_PRODUCTOS = " Te dejaremos estos productos como recomendacion a continuación";
    public static final String MENSAJE_NO_EXISTEN_PRODUCTOS = "No tenemos productos para recomendarte pero podemos darte el siguiente consejo: ";
    //private final LuxeneProductService luxeneProductService;
    private final AlmacenadorAudio almacenadorAudio;
    private final GeneradorAudio generadorAudio;
    private final RecomendacionProblema recomendacionProblema;
    private final ProblemaRepository problemaRepository;
    private final SugerenciaRepository sugerenciaRepository;
    public SugerenciaProblemaService(AlmacenadorAudio almacenadorAudio,
                                     GeneradorAudio generadorAudio,
                                     RecomendacionProblema recomendacionProblema,
                                     ProblemaRepository problemaRepository,
                                     SugerenciaRepository sugerenciaRepository) {
        this.almacenadorAudio = almacenadorAudio;
        this.generadorAudio = generadorAudio;
        this.recomendacionProblema = recomendacionProblema;
        this.problemaRepository = problemaRepository;
        this.sugerenciaRepository = sugerenciaRepository;
    }


    @Override
    public SugerenciaResponse obtenerRecomendacionYSugerencia(SugerenciaRequest sugerenciaRequest) {

        SugerenciaProblemaIADto sugerencia = this.recomendacionProblema.obtenerRecomendacion(sugerenciaRequest);

        var problema = this.problemaRepository.crear(new Problema(sugerenciaRequest.getProblema(),
                sugerenciaRequest.getEdadCliente(),
                sugerenciaRequest.getGeneroCliente(),
                sugerencia.getTipoProblema()));

        List<Integer> productIds = new ArrayList<>();//luxeneProductService.searchBestProductsAcordingToSuggestion(request.getMensaje(),sugerencia);

        String sugerenciaCliente = limpiarCaracteresEspecialesSugerencia(sugerencia.getRutinaSugeridaCliente());

        String sugerenciaFinalAAudio = obtenerMensajeSugerencia(sugerencia, productIds);
        InputStream sugerenciaAudio = this.generadorAudio.generarAudioConRecomendacion(sugerenciaFinalAAudio);
        String audioUrl = this.almacenadorAudio.guardarAudio(sugerenciaAudio);

        String ids = productIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        this.sugerenciaRepository.crear(new Sugerencia(
                sugerencia.getComponentesSugeridosCliente(),
                sugerencia.getRutinaSugeridaCliente(),
                audioUrl,
                ids,
                problema));

        return new SugerenciaResponse(sugerenciaCliente, audioUrl, productIds);

    }

    private static String obtenerMensajeSugerencia(SugerenciaProblemaIADto sugerencia, List<Integer> productosIds) {
        String sugerenciaFinal;

        if(!productosIds.isEmpty()){
            sugerenciaFinal = sugerencia.getRutinaSugeridaCliente().concat(MENSAJE_EXISTEN_PRODUCTOS);
        } else {
            sugerenciaFinal = MENSAJE_NO_EXISTEN_PRODUCTOS.concat(sugerencia.getRutinaSugeridaCliente());
        }
        return sugerenciaFinal;
    }

    public static String limpiarCaracteresEspecialesSugerencia(String problema) {
        problema = problema.replaceAll("<[^>]*>|\\r|\\n|\\t|\n|\r|\t", "");
        return problema;
    }

}
