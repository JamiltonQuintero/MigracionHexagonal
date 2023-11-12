package com.migracion.hexagonal.sugerencia.casosusos;

import com.migracion.hexagonal.sugerencia.dto.SugerenciaComando;
import com.migracion.hexagonal.sugerencia.mapper.SugerenciaDtoMapper;
import com.migracion.hexagonal.sugerencia.puerto.SugerenciaRepository;
import com.migracion.hexagonal.sugerencia.servicio.SugerenciaCreacion;
import com.migracion.hexagonal.sugerencia.servicio.SugerenciaEliminacion;
import com.migracion.hexagonal.sugerencia.servicio.SugerenciaModificacion;
import com.migracion.hexagonal.sugerencia.servicio.SugerenciaObtencion;
import org.springframework.stereotype.Service;

@Service
public class SugerenciaManejadorService implements SugerenciaCreacion, SugerenciaModificacion, SugerenciaEliminacion, SugerenciaObtencion {

    private final SugerenciaRepository sugerenciaRepository;
    public SugerenciaManejadorService(SugerenciaRepository sugerenciaRepository) {
        this.sugerenciaRepository = sugerenciaRepository;
    }

    @Override
    public void crear(SugerenciaComando sugerenciaComando) {
        this.sugerenciaRepository.crear(SugerenciaDtoMapper.toDominio(sugerenciaComando));
    }

}
