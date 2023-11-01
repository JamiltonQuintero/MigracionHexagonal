package com.migracion.hexagonal.beanconfiguracion;

import com.migracion.hexagonal.sugerencia.adaptador.externos.OpenIACliente;
import com.migracion.hexagonal.sugerencia.adaptador.externos.SugerenciaOpenIA;
import com.migracion.hexagonal.sugerencia.puerto.SugerenciaIA;
import com.migracion.hexagonal.sugerencia.servicio.RecomendacionProblema;
import com.migracion.hexagonal.sugerencia.servicio.impl.RecomendacionProblemaImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SugerenciaBean {

    @Bean
    public RecomendacionProblema recomendacionProblema(SugerenciaIA sugerenciaIA){
        return new RecomendacionProblemaImpl(sugerenciaIA);
    }

}
