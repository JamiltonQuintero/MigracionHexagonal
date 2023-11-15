package com.migracion.hexagonal.solucionproblema.puerto;

import java.io.InputStream;

public interface GeneradorAudio {
    InputStream generarAudioConRecomendacion(String messageToAudio);
}
