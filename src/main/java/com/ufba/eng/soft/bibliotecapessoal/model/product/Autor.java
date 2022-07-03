/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author joand
 */
@Data
@AllArgsConstructor
public class Autor {
    private int id;
    private String nome;

    public Autor(String nome) {
        this.nome = nome;
    }
    
}
