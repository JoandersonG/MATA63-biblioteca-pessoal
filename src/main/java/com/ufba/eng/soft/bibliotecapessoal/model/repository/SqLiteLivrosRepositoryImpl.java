package com.ufba.eng.soft.bibliotecapessoal.model.repository;

import com.ufba.eng.soft.bibliotecapessoal.model.db.LivroSQLiteOperations;
import com.ufba.eng.soft.bibliotecapessoal.model.db.SQLiteJDBCDriverConnection;
import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Aluno;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Orientando;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Professor;
import com.ufba.eng.soft.bibliotecapessoal.model.user.UsuarioDoSistema;

import java.util.List;

public class SqLiteLivrosRepositoryImpl implements LivrosRepository {

    public SqLiteLivrosRepositoryImpl() {
        SQLiteJDBCDriverConnection.connect();
    }

    @Override
    public List<Livro> getTodosOsLivros() {
        return LivroSQLiteOperations.getTodosOsLivros();
    }

    @Override
    public Livro getLivroPorISBN(String isbn) {
        return LivroSQLiteOperations.getLivroByIsbn(isbn);
    }

    @Override
    public List<Livro> getLivrosComTituloParcial(String tituloParcial) {
        return LivroSQLiteOperations.getLivrosByTituloParcial(tituloParcial);
    }

    @Override
    public boolean removerLivro(String isbn) {
        return LivroSQLiteOperations.removerLivroPorIsbn(isbn);
    }

    @Override
    public boolean adicionarNovoLivro(Livro livro) {
        return LivroSQLiteOperations.addLivro(livro);
    }

    @Override
    public void adicionarReservaAluno(Livro livro, Aluno aluno) {
        livro.setAlunosReserva(aluno);
        adicionarOuAtualizarLivro(livro);
    }

    @Override
    public void adicionarReservaProfessor(Livro livro, Professor professor) {
        livro.setProfessoresReserva(professor);
        adicionarOuAtualizarLivro(livro);
    }

    @Override
    public void adicionarReservaOrientando(Livro livro, Orientando orientando) {
        livro.setOrientandosReserva(orientando);
        adicionarOuAtualizarLivro(livro);
    }

    @Override
    public boolean atualizarLivro(Livro livro) {
        return LivroSQLiteOperations.atualizarLivro(livro);
    }

    @Override
    public boolean adicionarOuAtualizarLivro(Livro livro) {
        return LivroSQLiteOperations.atualizarLivro(livro) || LivroSQLiteOperations.addLivro(livro);
    }

    @Override
    public Livro getLivroPorCodBarras(String codBarras) {
        return LivroSQLiteOperations.getLivroByCodBarras(codBarras);
    }

}
