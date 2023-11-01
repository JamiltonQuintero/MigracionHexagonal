package com.migracion.hexagonal.problema.adaptador.repository;

import com.migracion.hexagonal.problema.adaptador.ProblemaJpaAdapterRepository;
import com.migracion.hexagonal.problema.adaptador.entity.ProblemaEntity;
import com.migracion.hexagonal.problema.adaptador.mapper.ProblemaMapper;
import com.migracion.hexagonal.problema.modelo.entity.Problema;
import com.migracion.hexagonal.problema.puerto.ProblemaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProblemaMySqlRepository implements ProblemaRepository {

    private final ProblemaJpaAdapterRepository problemaJpaAdapterRepository;

    public ProblemaMySqlRepository(ProblemaJpaAdapterRepository problemaJpaAdapterRepository) {
        this.problemaJpaAdapterRepository = problemaJpaAdapterRepository;
    }

    @Override
    public Problema crear(Problema problema) {
       var problemaGuardado = this.problemaJpaAdapterRepository
               .save(ProblemaMapper.toEntidad(problema));

       return ProblemaMapper.toDominio(problemaGuardado);
    }
}
