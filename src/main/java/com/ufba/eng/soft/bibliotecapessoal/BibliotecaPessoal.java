/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.ufba.eng.soft.bibliotecapessoal;

import com.ufba.eng.soft.bibliotecapessoal.front.view.GerenciadorDeTelas;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepositoryImpl;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.UsuariosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.UsuariosRepositoryImpl;
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
         gerenciadorDeTelas = new GerenciadorDeTelas(livrosRepository, usuariosRepository);
    }
 

    public static void main(String[] args) throws IOException  {
        setupInicial();
        
        //TODO: classe que orquestrará as telas do sistema, definindo qual tela será apresentada em qual momento.   ]
        
        /*
        Lógica pode ser algo como:
            - mostra tela de login para o usuário
            - depois do usuário logado, se for administrador, mostrar tela de administrador,
            - se for Orientador, mostrar tela de Orientador etc.
        */
        
        gerenciadorDeTelas.inicializaTelaPrincipalAdministrador();
    }
}
