/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author joand
 */
public class VerificadorDeCampos {
    
    private VerificadorDeCampos () {
        //Intencionalmente deixado vazio
    }
    
    public static ResultadoVerificacao nome(String nome) {
        if (nome == null) {
            return new ResultadoVerificacao(false, "Campo Nome não não pode ser nulo");
        }
        if (nome.isBlank()){
            return new ResultadoVerificacao(false, "Campo Nome não não pode estar vazio");
        }
        if (!nome.matches("[a-zA-Z].+ [a-zA-Z].+")) {
            new ResultadoVerificacao(false, "Insira nome e sobrenome, sem caracteres especiais ou acentuação");
        }
        return new ResultadoVerificacao(true);
    }
    
    
}
