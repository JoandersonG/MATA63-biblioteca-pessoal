/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.model.repository;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Aluno;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Orientando;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Professor;

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

   void adicionarReservaAluno(Livro livro, Aluno aluno);

   void adicionarReservaProfessor(Livro livro, Professor professor);

   void adicionarReservaOrientando(Livro livro, Orientando orientando);

   boolean atualizarLivro(Livro livro);
   
   boolean adicionarOuAtualizarLivro(Livro livro);

   Livro getLivroPorCodBarras(String identificacaoLivro);
}
