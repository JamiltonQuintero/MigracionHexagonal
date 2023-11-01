package com.migracion.hexagonal.sugerencia.adaptador.externos;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.polly.AmazonPolly;
import com.amazonaws.services.polly.AmazonPollyClientBuilder;
import com.amazonaws.services.polly.model.Engine;
import com.amazonaws.services.polly.model.OutputFormat;
import com.amazonaws.services.polly.model.SynthesizeSpeechRequest;
import com.amazonaws.services.polly.model.SynthesizeSpeechResult;
import com.amazonaws.services.polly.model.VoiceId;
import com.migracion.hexagonal.problema.modelo.excepcion.AwsException;
import com.migracion.hexagonal.sugerencia.adaptador.externos.utils.ConstantesGlobales;
import com.migracion.hexagonal.sugerencia.puerto.GeneradorAudio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;


@Service
@Slf4j
public class GeneradorAudioAws implements GeneradorAudio {

    private final String claveAcceso;
    private final String claveSecreta;

    public GeneradorAudioAws(@Value("${aws.polly.access-key}") String claveAcceso,
                                       @Value("${aws.polly.secret-key}")String claveSecreta) {
        this.claveAcceso = claveAcceso;
        this.claveSecreta = claveSecreta;
    }

    @Override
    public InputStream generarAudioConRecomendacion(String mensajeParaAudio) {
        InputStream flujoAudio;

        try {

            BasicAWSCredentials credencialesAws = new BasicAWSCredentials(this.claveAcceso, this.claveSecreta);

            AmazonPolly cliente = AmazonPollyClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(credencialesAws))
                    .withRegion(Regions.US_EAST_1)
                    .build();

            VoiceId idVoz = tipoVozBasadoEnTamanioMensaje(mensajeParaAudio);
            Engine motorVoz = tipoMotorBasadoEnTamanioMensaje(mensajeParaAudio);

            SynthesizeSpeechRequest solicitudSintesis = new SynthesizeSpeechRequest()
                    .withText(mensajeParaAudio)
                    .withVoiceId(idVoz)
                    .withOutputFormat(OutputFormat.Mp3)
                    .withEngine(motorVoz);
            SynthesizeSpeechResult resultadoSintesis = cliente.synthesizeSpeech(solicitudSintesis);
            flujoAudio = resultadoSintesis.getAudioStream();

            log.info(ConstantesGlobales.EXITO_COMUNICACION_AWS);
        } catch (Exception e) {
            log.error(ConstantesGlobales.ERROR_COMUNICACION_AWS, e);
            throw new AwsException(e.getMessage());
        }

        return flujoAudio;
    }

    private static VoiceId tipoVozBasadoEnTamanioMensaje(String mensajeParaAudio) {
        return mensajeParaAudio.length() <= ConstantesGlobales.LIMITE_VOZ_NEURAL ? VoiceId.Mia : VoiceId.Penelope;
    }

    private static Engine tipoMotorBasadoEnTamanioMensaje(String mensajeParaAudio) {
        return mensajeParaAudio.length() <= ConstantesGlobales.LIMITE_VOZ_NEURAL ? Engine.Neural : Engine.Standard;
    }

}
