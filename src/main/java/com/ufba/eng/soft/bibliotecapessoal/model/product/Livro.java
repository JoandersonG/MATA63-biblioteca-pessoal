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
public class Livro {
    private String nomeDoLivro;
    private Etiqueta etiqueta;
    private String codigoISBN;
    private String codigoDeBarras;
    private Autor autor;
    private GeneroLivro genero;
}
