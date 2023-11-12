package com.migracion.hexagonal.sugerencia.adaptador;

import com.migracion.hexagonal.sugerencia.adaptador.entity.SugerenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugerenciaJpaAdapterRepository extends JpaRepository<SugerenciaEntity, Long> {


}