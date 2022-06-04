/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.model.repository;


import com.ufba.eng.soft.bibliotecapessoal.model.user.Professor;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Aluno;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Orientando;
import java.util.List;

/**
 *
 * @author vanes
 */
public interface UsuariosRepository {
    
    
    List<Professor> getTodosOsAlunosCadastrados();
    List<Aluno> getTodosOsProfessoresCadastrados();
    List<Orientando> getTodosOsOrientandosCadastrados();
   
   
   boolean adicionarNovoProfessor(Professor professor);
   boolean adicionarNovoAluno(Aluno aluno);
   boolean adicionarNovoOrientando(Orientando orientando);
   
   boolean atualizarUsuarioProfessor(Professor professor);
   boolean atualizarUsuarioAluno(Aluno aluno);
   boolean atualizarUsuarioOrientando(Orientando orientando);
   
   boolean removerUsuarioProfessor(String id);
   boolean removerUsuarioAluno(String id);
   boolean removerUsuarioOrientando(String id);
   
}
