/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufba.eng.soft.bibliotecapessoal.model.repository;

import com.ufba.eng.soft.bibliotecapessoal.model.db.EmprestimoSQLiteOperations;
import com.ufba.eng.soft.bibliotecapessoal.model.db.LivroSQLiteOperations;
import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Aluno;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Orientando;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Professor;
import com.ufba.eng.soft.bibliotecapessoal.model.user.UsuarioDoSistema;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author vanes
 */

@Deprecated
public class UsuariosRepositoryImpl implements UsuariosRepository {
    
    private static ArrayList<UsuarioDoSistema> bancoDeUsuarios = new ArrayList<>();
    
    
    @Override
    public List<Professor> getTodosOsProfessoresCadastrados() {
        List<Professor> listaDeProfessores = new ArrayList<>();
        bancoDeUsuarios.forEach((usuario)-> {
            if(usuario instanceof Professor ){
                listaDeProfessores.add((Professor) usuario);
            }
        });
        return listaDeProfessores;
    }
    
    @Override
    public  List<Aluno> getTodosOsAlunosCadastrados() {
        List<Aluno> listaDeAlunos = new ArrayList<>();
        bancoDeUsuarios.forEach((usuario)-> {
            if(usuario instanceof Aluno ){
                listaDeAlunos.add((Aluno) usuario);
            }
        });
        return listaDeAlunos;
    }

    @Override
    public List<Orientando> getTodosOsOrientandosCadastrados() {
         List<Orientando> listaDeOrientandos = new ArrayList<>();
        bancoDeUsuarios.forEach((usuario)-> {
            if(usuario instanceof Orientando ){
                listaDeOrientandos.add((Orientando) usuario);
            }
        });
        return listaDeOrientandos;
    }


    @Override
    public boolean adicionarNovoProfessor(Professor professor) {
        System.out.println("Log: Adicionando novo professor no banco de dados: " + professor.getIdUsuario());
        return UsuariosRepositoryImpl.bancoDeUsuarios.add(professor);
    }

    @Override
    public boolean adicionarNovoAluno(Aluno aluno) {
        System.out.println("Log: Adicionando novo aluno no banco de dados: " + aluno.getIdUsuario());
        return UsuariosRepositoryImpl.bancoDeUsuarios.add(aluno);
    }

    @Override
    public boolean adicionarNovoOrientando(Orientando orientando) {
        System.out.println("Log: Adicionando novo orientando no banco de dados: " + orientando.getIdUsuario());
        return UsuariosRepositoryImpl.bancoDeUsuarios.add(orientando);
    }

    @Override
    public void atualizarUsuario(UsuarioDoSistema usuarioDoSistema) {
//        System.out.println("Log: Atualizando livros reservados professor: " + UsuariosRepositoryImpl.bancoDeUsuarios.get(index).getLivrosReservados());
//        throw new NotYetImplementedException();
    }

    @Override
    public boolean removerUsuario(String id) {
        AtomicBoolean result = new AtomicBoolean(false);
        bancoDeUsuarios.forEach(u -> {
            if (u.getIdUsuario().equals(id)) {
                result.set(bancoDeUsuarios.remove(u));
            }
        });
        return result.get();
    }

    @Override
    public Aluno consultarAlunoId(String id) {
        Aluno aluno = new Aluno();
        boolean encontrou = false;
        for (Aluno alunoListado : getTodosOsAlunosCadastrados() ){
                if(alunoListado.getIdUsuario().equals(id)){
                    aluno = alunoListado;
                   encontrou = true;
                }
        }
    return (encontrou)? aluno: null;
    }

    @Override
    public Professor consultarProfessorId(String id) {
        Professor professor = new Professor();
        boolean encontrou = false;
        for (Professor professorListado : getTodosOsProfessoresCadastrados() ){
                if(professorListado.getIdUsuario().equals(id)){
                   professor = professorListado;
                   encontrou = true;
                }
        }
    return (encontrou)? professor: null;
    }

    @Override
    public Orientando consultarOrientandoId(String id) {
        Orientando orientando = new Orientando();
        boolean encontrou = false;
        for (Orientando orientandoListado : getTodosOsOrientandosCadastrados() ){
                if(orientandoListado.getIdUsuario().equals(id)){
                   orientando = orientandoListado;
                   encontrou = true;
                }
        }
    return (encontrou)? orientando: null;
    }

    @Override
    public Aluno consultarAlunoNome(String nome) {
        Aluno aluno = new Aluno();
        boolean encontrou = false;
        for (Aluno alunoListado : getTodosOsAlunosCadastrados() ){
                if(alunoListado.getNomeDeUusario().equals(nome)){
                    aluno = alunoListado;
                   encontrou = true;
                }
        }
    return (encontrou)? aluno: null;
    }

    @Override
    public Professor consultarProfessorNome(String nome) {
        Professor professor = new Professor();
        boolean encontrou = false;
        for (Professor professorListado : getTodosOsProfessoresCadastrados() ){
                if(professorListado.getNomeDeUusario().equals(nome)){
                   professor = professorListado;
                   encontrou = true;
                }
        }
    return (encontrou)? professor: null;
    }

    @Override
    public Orientando consultarOrientandoNome(String nome) {
        Orientando orientando = new Orientando();
        boolean encontrou = false;
        for (Orientando orientandoListado : getTodosOsOrientandosCadastrados() ){
                if(orientandoListado.getNomeDeUusario().equals(nome)){
                   orientando = orientandoListado;
                   encontrou = true;
                }
        }
    return (encontrou)? orientando: null;
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
    public List<Livro> getTodasAsReservasDoUsuario(String idProfessor) {
        return null;
    }


}
