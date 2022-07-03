/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.model.repository;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Aluno;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Orientando;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Professor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Deprecated
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
    
    public Livro getLivroPorCodBarras(String cod) {
        for (Livro livro : this.livrosDatabase) {
            if (livro.getCodigoDeBarras().equals(cod)) {
                return livro;
            }
        }
        return null;
    }
    
    public Livro getLivroPorNome(String nome) {
        for (Livro livro : this.livrosDatabase) {
            if (livro.getNomeDoLivro().equals(nome)) {
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
        Livro livro = (Livro) this.getLivroPorISBN(isbn);

        if(livro != null){
            livrosDatabase.remove(livro);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean adicionarNovoLivro(Livro livro) {
        System.out.println("Log: Adicionando novo livro no banco de dados: " + livro.getNomeDoLivro());
        return livrosDatabase.add(livro);
    }
    
    @Override
    public void adicionarReservaAluno(Livro livro, Aluno aluno){
//        throw new NotYetImplementedException();
//        LivrosRepository.livrosDatabase.add(index, livro);
//        System.out.println("Log: Adicionando aluno em lista de reserva do livro: " + LivrosRepository.livrosDatabase.get(index).getAlunosReserva().get(0).getNomeDeUusario());
    }
    
    @Override
    public void adicionarReservaProfessor(Livro livro, Professor professor) {
//        throw new NotYetImplementedException();
//        LivrosRepository.livrosDatabase.add(index, livro);
//        System.out.println("Log: Adicionando professor em lista de reserva do livro: " + LivrosRepository.livrosDatabase.get(index).getProfessoresReserva().get(0).getNomeDeUusario());
    }
    
    @Override
    public void adicionarReservaOrientando(Livro livro, Orientando orientando){
//        throw new NotYetImplementedException();
//        LivrosRepository.livrosDatabase.add(index, livro);
//        System.out.println("Log: Adicionando orientando em lista de reserva do livro: " + LivrosRepository.livrosDatabase.get(index).getOrientandosReserva().get(0).getNomeDeUusario());
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
