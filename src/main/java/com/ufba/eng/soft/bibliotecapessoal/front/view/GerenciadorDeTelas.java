package com.ufba.eng.soft.bibliotecapessoal.front.view;

import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.UsuariosRepository;
import java.io.IOException;

/**
 * Classe com o objetivo de ser a responsável pelo gerenciamento de todas as 
 * telas da aplicação, de sua inicialização à sua finalização. Idealmente a 
 * classe principal BibliotecaPessoal.java se comunicará exclusivamente com
 * esta e não diretamente com cada tela.
 */
public class GerenciadorDeTelas {
    
    private final LivrosRepository livrosRepository;
    private final UsuariosRepository usuariosRepository;
    
    public GerenciadorDeTelas(LivrosRepository livrosRepository, UsuariosRepository usuariosRepository) {
       this.livrosRepository = livrosRepository;
       this.usuariosRepository = usuariosRepository;
    }
    
    /*public TelaPrincipalAdministrador inicializaTelaPrincipalAdministrador() throws IOException {
        TelaPrincipalAdministrador frame = new TelaPrincipalAdministrador(usuariosRepository, livrosRepository);
        frame.setVisible(true);
        return frame;
    }*/
    
    public TelaPrincipalBiblioteca inicializaTelaPrincipalBiblioteca() throws IOException {
        TelaPrincipalBiblioteca frame = new TelaPrincipalBiblioteca(usuariosRepository, livrosRepository);
        frame.setVisible(true);
        return frame;
    }
    
    /*public ConsultarLivroTelaPrincipal inicializaTelaPrincipal() {
        //ConsultarLivroTelaPrincipal frame = new ConsultarLivroTelaPrincipal(livrosRepository);
	frame.setVisible(true);
        return frame;
    }*/
   
}
