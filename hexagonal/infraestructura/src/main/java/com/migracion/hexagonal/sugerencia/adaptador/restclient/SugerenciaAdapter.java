package com.migracion.hexagonal.sugerencia.adaptador.restclient;

import com.migracion.hexagonal.sugerencia.modelo.dto.SugerenciaRequest;
import com.migracion.hexagonal.sugerencia.puerto.Sugerencia;
import org.springframework.stereotype.Service;


@Service
public class SugerenciaAdapter implements Sugerencia {

    private final SugerenciaCliente sugerenciaCliente;

    public SugerenciaAdapter(SugerenciaCliente sugerenciaCliente) {
        this.sugerenciaCliente = sugerenciaCliente;
    }

    @Override
    public void crear(SugerenciaRequest sugerencia) {
      this.sugerenciaCliente.guardar(sugerencia);
    }
}
