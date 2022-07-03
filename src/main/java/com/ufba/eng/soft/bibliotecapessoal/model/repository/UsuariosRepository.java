/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.model.repository;


import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
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
   
   void atualizarUsuario(UsuarioDoSistema usuario);

   boolean removerUsuario(String id);

   public Aluno consultarAlunoId(String id);
   public Professor consultarProfessorId(String id);
   public Orientando consultarOrientandoId(String id);
   
   public Aluno consultarAlunoNome(String nome);
   public Professor consultarProfessorNome(String nome);
   public Orientando consultarOrientandoNome(String nome);


    List<Livro> getTodosOsEmprestimosDoUsuario(String id);

    List<Livro> getTodasAsReservasDoUsuario(String idProfessor);
}
