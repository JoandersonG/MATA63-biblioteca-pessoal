/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.model.product;

import lombok.Data;

/**
 *
 * @author joand
 */
@Data
public class Autor {
    private String id;
    private String nome;

    public Autor(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
}
