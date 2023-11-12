package com.migracion.hexagonal.problema.casosusos;

import com.migracion.hexagonal.problema.dto.ProblemaComando;
import com.migracion.hexagonal.problema.dto.ProblemaDto;
import com.migracion.hexagonal.problema.mapper.ProblemaDtoMapper;
import com.migracion.hexagonal.problema.puerto.ProblemaRepository;
import com.migracion.hexagonal.problema.servicio.ProblemaCreacion;
import com.migracion.hexagonal.problema.servicio.ProblemaEliminacion;
import com.migracion.hexagonal.problema.servicio.ProblemaModificacion;
import com.migracion.hexagonal.problema.servicio.ProblemaObtencion;
import org.springframework.stereotype.Service;

@Service
public class ProblemaManejadorService implements ProblemaCreacion, ProblemaModificacion, ProblemaEliminacion, ProblemaObtencion {

    private final ProblemaRepository problemaRepository;
    public ProblemaManejadorService(ProblemaRepository problemaRepository) {
        this.problemaRepository = problemaRepository;
    }

    @Override
    public ProblemaDto crear(ProblemaComando problemaComando) {
       var problemaGuardado = this.problemaRepository.crear(ProblemaDtoMapper.toDominio(problemaComando));
        return ProblemaDtoMapper.toDto(problemaGuardado);
    }

}
