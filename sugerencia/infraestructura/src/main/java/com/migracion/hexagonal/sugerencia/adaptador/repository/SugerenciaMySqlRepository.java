package com.migracion.hexagonal.sugerencia.adaptador.repository;

import com.migracion.hexagonal.sugerencia.adaptador.SugerenciaJpaAdapterRepository;
import com.migracion.hexagonal.sugerencia.adaptador.mapper.SugerenciaEntityMapper;
import com.migracion.hexagonal.sugerencia.entity.Sugerencia;
import com.migracion.hexagonal.sugerencia.puerto.SugerenciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SugerenciaMySqlRepository implements SugerenciaRepository {

    private final SugerenciaJpaAdapterRepository sugerenciaJpaAdapterRepository;

    public SugerenciaMySqlRepository(SugerenciaJpaAdapterRepository sugerenciaJpaAdapterRepository) {
        this.sugerenciaJpaAdapterRepository = sugerenciaJpaAdapterRepository;
    }

    @Override
    public void crear(Sugerencia sugerencia) {
      this.sugerenciaJpaAdapterRepository
              .save(SugerenciaEntityMapper.toEntidadCrear(sugerencia));
    }

}
