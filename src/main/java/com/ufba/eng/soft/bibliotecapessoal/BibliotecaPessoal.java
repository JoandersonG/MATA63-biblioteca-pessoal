/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.ufba.eng.soft.bibliotecapessoal;

import com.ufba.eng.soft.bibliotecapessoal.front.view.GerenciadorDeTelas;
import com.ufba.eng.soft.bibliotecapessoal.model.product.Autor;
import com.ufba.eng.soft.bibliotecapessoal.model.product.GeneroLivro;
import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepositoryImpl;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.UsuariosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.UsuariosRepositoryImpl;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Aluno;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Orientando;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Professor;
import java.io.IOException;


/**
 *
 * @author joand
 */
public class BibliotecaPessoal {
    
    private static GerenciadorDeTelas gerenciadorDeTelas;

    private static void setupInicial() {
         LivrosRepository livrosRepository = new LivrosRepositoryImpl();
         UsuariosRepository usuariosRepository = new UsuariosRepositoryImpl();
         
        //DATABASE - Usuários
        Aluno aluno = new Aluno("ID0001", "Guilherme Costa", "guicosta", "21612260");
        Orientando orientador = new Orientando("ID0002", "Godofredo Junior", "godjr", "21222222");
        Professor professor = new Professor("ID0003", "Ivan Machado", "guicosta", "21333333");
        
        usuariosRepository.adicionarNovoAluno(aluno);
        usuariosRepository.adicionarNovoOrientando(orientador);
        usuariosRepository.adicionarNovoProfessor(professor);
        
        //DATABASE - Livros
        Livro livro1 = new Livro("Engenharia de Software", "100", "001", "Ian Sommervile", GeneroLivro.DIDATICO);
        Livro livro2 = new Livro("UML - Guia do Usuario", "101", "002", "Grady Booch, James Rumbaugh", GeneroLivro.DIDATICO);
        Livro livro9 = new Livro("Code Complete Microsoft Press", "200", "003", "Steve McConnell", GeneroLivro.DIDATICO);
        Livro livro3 = new Livro("Agile Software\n Development Principles, Patterns,and Practices", "201","004","Prentice Hall", GeneroLivro.DIDATICO);
        Livro livro4 = new Livro("Refactoring: Improving the Design of Existing Code", "300", "005","Martin Fowler", GeneroLivro.DIDATICO);
        Livro livro5 = new Livro("Software Metrics: A Rigorous and Practical Approach", "301", "006", "Norman Fenton, James Bieman", GeneroLivro.DIDATICO);
        Livro livro6 = new Livro("Design Patterns: Elements of Reusable Object-Oriented Software", "400", "007", "Erich Gamma, Richard Helm", GeneroLivro.DIDATICO);
        Livro livro7 = new Livro("UML Distilled: A Brief Guide to the Standard Object Modeling Language", "401", "008", "Martin Fowler", GeneroLivro.DIDATICO);

        livrosRepository.adicionarNovoLivro(livro1);
        livrosRepository.adicionarNovoLivro(livro2);
        livrosRepository.adicionarNovoLivro(livro3);
        livrosRepository.adicionarNovoLivro(livro4);
        livrosRepository.adicionarNovoLivro(livro5);
        livrosRepository.adicionarNovoLivro(livro6);
        livrosRepository.adicionarNovoLivro(livro7);
        livrosRepository.adicionarNovoLivro(livro9);
        
        gerenciadorDeTelas = new GerenciadorDeTelas(livrosRepository, usuariosRepository);
    }
 

    public static void main(String[] args) throws IOException  {
        setupInicial();

        //TODO: classe que orquestrar� as telas do sistema, definindo qual tela ser� apresentada em qual momento.   ]
        
        /*
        L�gica pode ser algo como:
            - mostra tela de login para o usu�rio
            - depois do usu�rio logado, se for administrador, mostrar tela de administrador,
            - se for Orientador, mostrar tela de Orientador etc.
        */
        
        gerenciadorDeTelas.inicializaTelaPrincipalBiblioteca();
    }
}
