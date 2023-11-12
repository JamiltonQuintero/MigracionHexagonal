package com.migracion.hexagonal.sugerencia.entity;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Sugerencia {

    private Long id;
    private SolucionComponenteQuimico solucionComponenteQuimico;
    private SolucionRutina solucionRutina;
    private UrlAudio urlAudio;
    private IdsProductos idsProductos;
    private ProblemaId problemaId;

    public Sugerencia(
            String solucionComponenteQuimico,
            String solucionRutina,
            String urlAudio,
            String idsProductos,
            Long problemaId) {
        this.solucionComponenteQuimico = new SolucionComponenteQuimico(solucionComponenteQuimico);
        this.solucionRutina = new SolucionRutina(solucionRutina);
        this.urlAudio = new UrlAudio(urlAudio);
        this.idsProductos = new IdsProductos(idsProductos);
        this.problemaId = new ProblemaId(problemaId);
    }

    public Long getId() {
        return id;
    }

    public String getSolucionComponenteQuimico() {
        return solucionComponenteQuimico.getValor();
    }

    public String getSolucionRutina() {
        return solucionRutina.getValor();
    }

    public String getUrlAudio() {
        return urlAudio.getValor();
    }

    public String getIdsProductos() {
        return idsProductos.getValor();
    }
    public Long getProblemaId() {
        return problemaId.getValor();
    }

}
