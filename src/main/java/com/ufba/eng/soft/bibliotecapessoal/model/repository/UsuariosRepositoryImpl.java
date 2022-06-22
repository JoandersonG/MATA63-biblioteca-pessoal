/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufba.eng.soft.bibliotecapessoal.model.repository;

import com.ufba.eng.soft.bibliotecapessoal.model.user.Administrador;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Aluno;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Orientando;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Professor;
import com.ufba.eng.soft.bibliotecapessoal.model.user.UsuarioDoSistema;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vanes
 */
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
    public void atualizarUsuarioProfessor(Professor professor, int index) {
        System.out.println("Log: Atualizando livros reservados professor: " + UsuariosRepositoryImpl.bancoDeUsuarios.get(index).getLivrosReservados());
        UsuariosRepositoryImpl.bancoDeUsuarios.add(index, professor);
    }
    
    @Override
    public void atualizarUsuarioAluno(Aluno aluno, int index) {
        System.out.println("Log: Atualizando livros reservado aluno: " + UsuariosRepositoryImpl.bancoDeUsuarios.get(index).getLivrosReservados());
        UsuariosRepositoryImpl.bancoDeUsuarios.add(index, aluno);
    }
    
    @Override
    public void atualizarUsuarioOrientando(Orientando orientando, int index) {
        System.out.println("Log: Atualizando livros reservado orientando: " + UsuariosRepositoryImpl.bancoDeUsuarios.get(index).getLivrosReservados()); //isso pode apagar depois
        UsuariosRepositoryImpl.bancoDeUsuarios.add(index, orientando);
    }

    @Override
    public boolean removerUsuarioProfessor(String id) {
        for (Professor professorListado : getTodosOsProfessoresCadastrados() ){
                if(professorListado.getIdUsuario().equals(id)){
                   System.out.println("Log: Removendo professor do banco de dados: " + professorListado.getIdUsuario());
                   UsuariosRepositoryImpl.bancoDeUsuarios.remove(professorListado);
                   return true;
                }
        }
        return false;
    }

    @Override
    public boolean removerUsuarioAluno(String id) {
        for (Aluno alunoListado : getTodosOsAlunosCadastrados() ){
                if(alunoListado.getIdUsuario().equals(id)){
                   System.out.println("Log: Removendo aluno do banco de dados: " + alunoListado.getIdUsuario());
                   UsuariosRepositoryImpl.bancoDeUsuarios.remove(alunoListado);
                   return true;
                }
        }
        return false;
    }

    @Override
    public boolean removerUsuarioOrientando(String id) {
        for (Orientando orientandoListado : getTodosOsOrientandosCadastrados() ){
                if(orientandoListado.getIdUsuario().equals(id)){
                   System.out.println("Log: Removendo orientando do banco de dados: " + orientandoListado.getIdUsuario());
                   UsuariosRepositoryImpl.bancoDeUsuarios.remove(orientandoListado);
                   return true;
                }
        }
        return false;
    }

    @Override
    public UsuarioDoSistema consultarAlunoId(String id) {
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
    public UsuarioDoSistema consultarProfessorId(String id) {
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
    public UsuarioDoSistema consultarOrientandoId(String id) {
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
    public UsuarioDoSistema consultarAlunoNome(String nome) {
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
    public UsuarioDoSistema consultarProfessorNome(String nome) {
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
    public UsuarioDoSistema consultarOrientandoNome(String nome) {
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

    

    
    
}
