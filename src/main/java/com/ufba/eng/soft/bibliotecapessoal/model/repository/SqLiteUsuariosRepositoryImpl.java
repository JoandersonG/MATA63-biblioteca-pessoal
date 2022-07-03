package com.ufba.eng.soft.bibliotecapessoal.model.repository;

import com.ufba.eng.soft.bibliotecapessoal.model.db.*;
import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import com.ufba.eng.soft.bibliotecapessoal.model.user.*;

import java.util.ArrayList;
import java.util.List;

public class SqLiteUsuariosRepositoryImpl implements UsuariosRepository {

    public SqLiteUsuariosRepositoryImpl() {
        SQLiteJDBCDriverConnection.connect();
    }

    @Override
    public List<Professor> getTodosOsProfessoresCadastrados() {
        return UsuarioSQLiteOperations.getUsuariosPorTipo(TipoUsuario.PROFESSOR);
    }

    @Override
    public List<Aluno> getTodosOsAlunosCadastrados() {
        return UsuarioSQLiteOperations.getUsuariosPorTipo(TipoUsuario.ALUNO);
    }

    @Override
    public List<Orientando> getTodosOsOrientandosCadastrados() {
        return UsuarioSQLiteOperations.getUsuariosPorTipo(TipoUsuario.ORIENTANDO);
    }

    @Override
    public boolean adicionarNovoProfessor(Professor professor) {
        return UsuarioSQLiteOperations.addUsuario(professor);
    }

    @Override
    public boolean adicionarNovoAluno(Aluno aluno) {
        return UsuarioSQLiteOperations.addUsuario(aluno);
    }

    @Override
    public boolean adicionarNovoOrientando(Orientando orientando) {
        return UsuarioSQLiteOperations.addUsuario(orientando);
    }

    @Override
    public void atualizarUsuario(UsuarioDoSistema usuario) {
        UsuarioSQLiteOperations.atualizarUsuario(usuario);
    }

    @Override
    public boolean removerUsuario(String id) {
        return UsuarioSQLiteOperations.removerUsuarioPorId(id);
    }

    @Override
    public Aluno consultarAlunoId(String id) {
        UsuarioDoSistema usuarioFromId = UsuarioSQLiteOperations.getUsuarioFromId(id);
        return usuarioFromId instanceof Aluno ? (Aluno) usuarioFromId : null;
    }

    @Override
    public Professor consultarProfessorId(String id) {
        UsuarioDoSistema usuarioFromId = UsuarioSQLiteOperations.getUsuarioFromId(id);
        return usuarioFromId instanceof Professor ? (Professor) usuarioFromId : null;
    }

    @Override
    public Orientando consultarOrientandoId(String id) {
        UsuarioDoSistema usuarioFromId = UsuarioSQLiteOperations.getUsuarioFromId(id);
        return usuarioFromId instanceof Orientando ? (Orientando) usuarioFromId : null;
    }

    @Override
    public Aluno consultarAlunoNome(String nome) {
        UsuarioDoSistema usuarioFromNome = UsuarioSQLiteOperations.getUsuarioFromNome(nome);
        return usuarioFromNome instanceof Aluno ? (Aluno) usuarioFromNome : null;
    }

    @Override
    public Professor consultarProfessorNome(String nome) {
        UsuarioDoSistema usuarioFromNome = UsuarioSQLiteOperations.getUsuarioFromNome(nome);
        return usuarioFromNome instanceof Professor ? (Professor) usuarioFromNome : null;
    }

    @Override
    public Orientando consultarOrientandoNome(String nome) {
        UsuarioDoSistema usuarioFromNome = UsuarioSQLiteOperations.getUsuarioFromNome(nome);
        return usuarioFromNome instanceof Orientando ? (Orientando) usuarioFromNome : null;
    }

    @Override
    public List<Livro> getTodosOsEmprestimosDoUsuario(String id) {
        List<String> isbns = EmprestimoSQLiteOperations.getTodosOsEmprestimosParaUsuario(id);
        ArrayList<Livro> livros = new ArrayList<>();
        for (String isbn : isbns) {
            livros.add(LivroSQLiteOperations.getLivroByIsbn(isbn));
        }
        return livros;
    }

    @Override
    public List<Livro> getTodasAsReservasDoUsuario(String id) {
        List<String> isbns = ReservaSQLiteOperations.getTodasAsReservasParaUsuario(id);
        ArrayList<Livro> livros = new ArrayList<>();
        for (String isbn : isbns) {
            livros.add(LivroSQLiteOperations.getLivroByIsbn(isbn));
        }
        return livros;
    }
}
