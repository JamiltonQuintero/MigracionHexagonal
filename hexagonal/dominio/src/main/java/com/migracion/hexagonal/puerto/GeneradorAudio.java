package com.migracion.hexagonal.puerto;

import java.io.InputStream;

public interface GeneradorAudio {
    InputStream generarAudioConRecomendacion(String messageToAudio);
}
