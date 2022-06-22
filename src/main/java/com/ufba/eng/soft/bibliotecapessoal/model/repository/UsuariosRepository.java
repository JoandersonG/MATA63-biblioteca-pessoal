/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.model.repository;


import com.ufba.eng.soft.bibliotecapessoal.model.user.Professor;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Aluno;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Orientando;
import com.ufba.eng.soft.bibliotecapessoal.model.user.UsuarioDoSistema;
import java.util.List;

/**
 *
 * @author vanes
 */
public interface UsuariosRepository {
    
    List<Professor> getTodosOsProfessoresCadastrados();
    List<Aluno> getTodosOsAlunosCadastrados();
    List<Orientando> getTodosOsOrientandosCadastrados();
   
   
   boolean adicionarNovoProfessor(Professor professor);
   boolean adicionarNovoAluno(Aluno aluno);
   boolean adicionarNovoOrientando(Orientando orientando);
   
   void atualizarUsuarioProfessor(Professor professor, int index);
   void atualizarUsuarioAluno(Aluno aluno, int index);
   void atualizarUsuarioOrientando(Orientando orientando, int index);
   
   boolean removerUsuarioProfessor(String id);
   boolean removerUsuarioAluno(String id);
   boolean removerUsuarioOrientando(String id);
   
   public UsuarioDoSistema consultarAlunoId(String id);
   public UsuarioDoSistema consultarProfessorId(String id);
   public UsuarioDoSistema consultarOrientandoId(String id);
   
   public UsuarioDoSistema consultarAlunoNome(String nome);
   public UsuarioDoSistema consultarProfessorNome(String nome);
   public UsuarioDoSistema consultarOrientandoNome(String nome);
   
   
}
