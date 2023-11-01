package com.migracion.hexagonal.problema.puerto;

import com.migracion.hexagonal.problema.modelo.entity.Problema;

public interface ProblemaRepository {

    Problema crear(Problema problema);

}
