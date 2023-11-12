package com.migracion.hexagonal.problema.servicio;

import com.migracion.hexagonal.problema.dto.ProblemaComando;
import com.migracion.hexagonal.problema.dto.ProblemaDto;

public interface ProblemaCreacion {

    ProblemaDto crear(ProblemaComando problemaComando);

}
