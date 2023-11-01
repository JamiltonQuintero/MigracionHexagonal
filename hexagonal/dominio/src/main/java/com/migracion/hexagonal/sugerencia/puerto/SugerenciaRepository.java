package com.migracion.hexagonal.sugerencia.puerto;

import com.migracion.hexagonal.sugerencia.modelo.entity.Sugerencia;

public interface SugerenciaRepository {

    void crear(Sugerencia sugerencia);

}
