package com.migracion.hexagonal.problema.adaptador.repository;

import com.migracion.hexagonal.problema.adaptador.ProblemaJpaAdapterRepository;
import com.migracion.hexagonal.problema.adaptador.mapper.ProblemaEntityMapper;
import com.migracion.hexagonal.problema.entity.Problema;
import com.migracion.hexagonal.problema.puerto.ProblemaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


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
               .save(ProblemaEntityMapper.toEntidadCrear(problema));

       return ProblemaEntityMapper.toDominio(problemaGuardado);
    }
}
