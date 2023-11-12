package com.migracion.hexagonal.problema.adaptador.restclient;

import com.migracion.hexagonal.problema.modelo.dto.ProblemaDto;
import com.migracion.hexagonal.problema.modelo.dto.ProblemaRequest;
import com.migracion.hexagonal.problema.puerto.Problema;
import org.springframework.stereotype.Service;


@Service
public class ProblemaAdapter implements Problema {

    private final ProblemaCliente problemaCliente;

    public ProblemaAdapter(ProblemaCliente problemaCliente) {
        this.problemaCliente = problemaCliente;
    }

    @Override
    public ProblemaDto crear(ProblemaRequest problema) {
       return this.problemaCliente
               .guardar(problema);
    }

}
