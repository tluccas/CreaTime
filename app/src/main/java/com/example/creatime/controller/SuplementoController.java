package com.example.creatime.controller;

import com.example.creatime.model.Suplemento;
import com.example.creatime.model.SuplementoStatus;
import com.example.creatime.model.TipoSuplemento;
import com.example.creatime.service.exception.StatusInvalidoException;

public class SuplementoController {

    public Suplemento criarSuplemento(String nome, String dosagem, int hora, int minuto, TipoSuplemento tipo){
        Suplemento suplemento = new Suplemento(nome, dosagem, hora, minuto, tipo);
        suplemento.setStatus(SuplementoStatus.ATIVO);

        return suplemento;
    }

    public void atualizarStatus(Suplemento suplemento, String status) throws StatusInvalidoException {

        switch (status){
            case "ATIVO":
                suplemento.setStatus(SuplementoStatus.ATIVO);
                break;
            case "PENDENTE":
                suplemento.setStatus(SuplementoStatus.PENDENTE);
                break;
            case "TOMADO":
                suplemento.setStatus(SuplementoStatus.TOMADO);
                break;
            default:
               throw new StatusInvalidoException();

        }

    }
}
