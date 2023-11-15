package com.migracion.hexagonal.problema.puerto;


import com.migracion.hexagonal.problema.modelo.dto.ProblemaDto;
import com.migracion.hexagonal.problema.modelo.dto.ProblemaRequest;
import com.migracion.hexagonal.solucionproblema.modelo.dto.SolucionProblemaDto;

import java.util.Optional;

public interface Problema {

    Optional<ProblemaDto> crear(SolucionProblemaDto solucionProblema);

}
