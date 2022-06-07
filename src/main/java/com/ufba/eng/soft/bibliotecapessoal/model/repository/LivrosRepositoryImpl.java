/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.model.repository;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LivrosRepositoryImpl implements LivrosRepository {
    
    private static ArrayList<Livro> livrosDatabase = new ArrayList<>();

    @Override
    public List<Livro> getTodosOsLivros() {
        return Collections.unmodifiableList(livrosDatabase);
    }

    @Override
    public Livro getLivroPorISBN(String isbn) {
        for (Livro livro : this.livrosDatabase) {
            if (livro.getCodigoISBN().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }

    @Override
    public List<Livro> getLivrosComTituloParcial(String tituloParcial) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removerLivro(String isbn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean adicionarNovoLivro(Livro livro) {
        System.out.println("Log: Adicionando novo livro no banco de dados: " + livro.getNomeDoLivro());
        return LivrosRepositoryImpl.livrosDatabase.add(livro);
    }

    @Override
    public boolean atualizarLivro(Livro livro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean adicionarOuAtualizarLivro(Livro livro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
