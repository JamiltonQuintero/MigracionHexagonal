package com.migracion.hexagonal.problema.adaptador;


import com.migracion.hexagonal.problema.adaptador.entity.ProblemaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemaJpaAdapterRepository extends JpaRepository<ProblemaEntity, Long> {


}