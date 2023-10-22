package com.migracion.hexagonal.puerto;

import java.io.InputStream;

public interface AlmacenadorAudio {

    String guardarAudio(InputStream audioRecomendacion);

}
