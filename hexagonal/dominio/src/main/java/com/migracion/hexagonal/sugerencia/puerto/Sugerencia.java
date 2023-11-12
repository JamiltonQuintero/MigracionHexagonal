package com.migracion.hexagonal.sugerencia.puerto;

import com.migracion.hexagonal.sugerencia.modelo.dto.SugerenciaRequest;

public interface Sugerencia {

    void crear(SugerenciaRequest sugerencia);

}
