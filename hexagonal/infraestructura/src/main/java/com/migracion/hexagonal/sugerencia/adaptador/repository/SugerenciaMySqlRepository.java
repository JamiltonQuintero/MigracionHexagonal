package com.migracion.hexagonal.sugerencia.adaptador.repository;

import com.migracion.hexagonal.sugerencia.adaptador.SugerenciaJpaAdapterRepository;
import com.migracion.hexagonal.sugerencia.adaptador.mapper.SugerenciaMapper;
import com.migracion.hexagonal.sugerencia.modelo.entity.Sugerencia;
import com.migracion.hexagonal.sugerencia.puerto.SugerenciaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SugerenciaMySqlRepository implements SugerenciaRepository {

    private final SugerenciaJpaAdapterRepository sugerenciaJpaAdapterRepository;

    public SugerenciaMySqlRepository(SugerenciaJpaAdapterRepository sugerenciaJpaAdapterRepository) {
        this.sugerenciaJpaAdapterRepository = sugerenciaJpaAdapterRepository;
    }

    @Override
    public void crear(Sugerencia sugerencia) {

      this.sugerenciaJpaAdapterRepository.save(SugerenciaMapper.toEntidadCrear(sugerencia));

    }
}
