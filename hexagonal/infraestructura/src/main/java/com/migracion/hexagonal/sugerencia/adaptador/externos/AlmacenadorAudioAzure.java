package com.migracion.hexagonal.sugerencia.adaptador.externos;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.migracion.hexagonal.sugerencia.adaptador.externos.utils.ConstantesGlobales;
import com.migracion.hexagonal.sugerencia.puerto.AlmacenadorAudio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class AlmacenadorAudioAzure implements AlmacenadorAudio {

    private final String cadenaConexion;
    private final String nombreContenedor;

    public AlmacenadorAudioAzure(@Value("${azure.storage.connection-string}") String cadenaConexion,
                            @Value("${azure.storage.containerName}")String nombreContenedor) {
        this.cadenaConexion = cadenaConexion;
        this.nombreContenedor = nombreContenedor;
    }

    @Override
    public String guardarAudio(InputStream audioRecomendacion) {
        byte[] flujoSalidaAudio;
        try {
            flujoSalidaAudio = generarBytesVoz(audioRecomendacion);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int longitudAudio = flujoSalidaAudio.length;
        InputStream flujoEntradaAudio = new ByteArrayInputStream(flujoSalidaAudio);

        try {
            BlobContainerClient clienteContenedor = obtenerClienteContenedor(this.nombreContenedor);
            BlobClient clienteBlob = clienteContenedor.getBlobClient(generarNombreAudio());
            clienteBlob.upload(flujoEntradaAudio, longitudAudio);
            return clienteBlob.getBlobUrl();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private byte[] generarBytesVoz(InputStream flujoVoz) throws IOException {
        ByteArrayOutputStream flujoSalida = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesLeidos;
        while ((bytesLeidos = flujoVoz.read(buffer)) != -1) {
            flujoSalida.write(buffer, 0, bytesLeidos);
        }
        return flujoSalida.toByteArray();
    }

    private BlobContainerClient obtenerClienteContenedor(String nombreContenedor) {
        BlobServiceClient clienteServicioBlob = new BlobServiceClientBuilder().connectionString(cadenaConexion).buildClient();
        return clienteServicioBlob.getBlobContainerClient(nombreContenedor);
    }

    private static String generarNombreAudio() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(ConstantesGlobales.FORMATO_FECHA)) +
                ConstantesGlobales.DELIMITADOR + UUID.randomUUID() +
                ConstantesGlobales.FORMATO_AUDIO;
    }
}
