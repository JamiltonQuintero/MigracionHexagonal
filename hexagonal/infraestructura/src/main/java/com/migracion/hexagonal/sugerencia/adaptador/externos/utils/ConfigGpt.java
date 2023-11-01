package com.migracion.hexagonal.sugerencia.adaptador.externos.utils;

public class ConfigGpt {

    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final String MODELO = "text-davinci-002";
    public static final Integer TOKEN_MAXIMO = 600;
    public static final Double TEMPERATURA = 0.0;
    public static final Double TOP_P = 1.0;
    public static final String MEDIA_TYPE = "application/json; charset=UTF-8";
    public static final String URL = "https://api.openai.com/v1/completions";

}