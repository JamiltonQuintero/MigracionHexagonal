package com.migracion.hexagonal.solucionproblema.puerto;

import java.io.InputStream;

public interface AlmacenadorAudio {

    String guardarAudio(InputStream audioRecomendacion);

}
