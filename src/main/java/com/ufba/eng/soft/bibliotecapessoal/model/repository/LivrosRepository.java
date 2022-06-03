/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.model.repository;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import java.util.List;

/**
 *
 * @author joand
 */
public interface LivrosRepository {
    
   List<Livro> getTodosOsLivros();
   
   Livro getLivroPorISBN(String isbn);
   
   List<Livro> getLivrosComTituloParcial(String tituloParcial);
   
   boolean removerLivro(String isbn);
   
   boolean adicionarNovoLivro(Livro livro);
   
   boolean atualizarLivro(Livro livro);
   
   boolean adicionarOuAtualizarLivro(Livro livro);
   
}
