package com.migracion.hexagonal.sugerencia.puerto;

import java.io.InputStream;

public interface GeneradorAudio {
    InputStream generarAudioConRecomendacion(String messageToAudio);
}
