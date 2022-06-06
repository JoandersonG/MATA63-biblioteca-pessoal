/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.util;

import lombok.Data;

/**
 *
 * @author joand
 */
@Data
public class ResultadoVerificacao {
    private boolean isValido;
    private String motivo;

    ResultadoVerificacao(boolean isValido, String motivo) {
        this.isValido = isValido;
        this.motivo = motivo;
    }
    
     ResultadoVerificacao(boolean isValido) {
        this.isValido = isValido;
    }

}
