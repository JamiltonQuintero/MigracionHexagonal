package com.migracion.hexagonal.beanconfiguracion;

import com.migracion.hexagonal.solucionproblema.puerto.SugerenciaIA;
import com.migracion.hexagonal.solucionproblema.servicio.RecomendacionProblema;
import com.migracion.hexagonal.solucionproblema.servicio.impl.RecomendacionProblemaImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SugerenciaBean {

    @Bean
    public RecomendacionProblema recomendacionProblema(SugerenciaIA sugerenciaIA){
        return new RecomendacionProblemaImpl(sugerenciaIA);
    }

}
