package com.migracion.hexagonal.problema.puerto;


import com.migracion.hexagonal.problema.modelo.dto.ProblemaDto;
import com.migracion.hexagonal.problema.modelo.dto.ProblemaRequest;

public interface Problema {

    ProblemaDto crear(ProblemaRequest problema);

}
