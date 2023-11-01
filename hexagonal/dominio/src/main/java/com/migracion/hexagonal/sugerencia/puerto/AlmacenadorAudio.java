package com.migracion.hexagonal.sugerencia.puerto;

import java.io.InputStream;

public interface AlmacenadorAudio {

    String guardarAudio(InputStream audioRecomendacion);

}
