package com.migracion.hexagonal.solucionproblema.puerto;

import com.migracion.hexagonal.solucionproblema.modelo.dto.SolucionProblemaDto;

public interface SolucionPersistencia {

    void guardarSolucionProblema(SolucionProblemaDto solucionProblema);

}
