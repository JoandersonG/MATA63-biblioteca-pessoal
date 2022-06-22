/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.model.product;

import lombok.Data;

//Falta incluir etiqueta

@Data
public class Livro {
    private String nomeDoLivro;
    //private Etiqueta etiqueta;
    private String codigoISBN;
    private String codigoDeBarras;
    private Autor autor;
    public GeneroLivro genero;
    private boolean emprestado = false;
    private boolean reservado = false;

        public Livro(String nomeDoLivro, String codigoISBN, String codigoDeBarras, Autor autor, GeneroLivro genero) {
        this.nomeDoLivro = nomeDoLivro;
        this.codigoISBN = codigoISBN;
        this.codigoDeBarras = codigoDeBarras;
        this.autor = autor;
        this.genero = genero;
    }
    
}
