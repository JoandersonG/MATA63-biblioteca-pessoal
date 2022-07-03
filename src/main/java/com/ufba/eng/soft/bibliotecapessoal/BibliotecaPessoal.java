/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.ufba.eng.soft.bibliotecapessoal;

import com.ufba.eng.soft.bibliotecapessoal.front.view.GerenciadorDeTelas;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.*;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;

import java.io.IOException;


/**
 *
 * @author joand
 */
public class BibliotecaPessoal {
    
    private static GerenciadorDeTelas gerenciadorDeTelas;

    private static void setupInicial() {
         LivrosRepository livrosRepository = new SqLiteLivrosRepositoryImpl();
         UsuariosRepository usuariosRepository = new SqLiteUsuariosRepositoryImpl();
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
