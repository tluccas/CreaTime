package com.example.creatime.model;



public class Suplemento {
    private String nome;
    private String dosagem;
    private int hora;
    private int minuto;
    private SuplementoStatus status;
    private TipoSuplemento tipo;

    public Suplemento(String nome, String dosagem, int hora, int minuto, TipoSuplemento tipo) {
        this.nome = nome;
        this.dosagem = dosagem;
        this.hora = hora;
        this.minuto = minuto;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public SuplementoStatus getStatus() {
        return status;
    }

    public void setStatus(SuplementoStatus status) {
        this.status = status;
    }

    public TipoSuplemento getTipo() {
        return tipo;
    }

    public void setTipo(TipoSuplemento tipo) {
        this.tipo = tipo;
    }
}
