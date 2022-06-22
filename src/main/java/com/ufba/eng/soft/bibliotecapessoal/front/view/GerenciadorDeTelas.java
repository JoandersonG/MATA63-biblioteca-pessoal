package com.ufba.eng.soft.bibliotecapessoal.front.view;

import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.UsuariosRepository;
import java.io.IOException;

/**
 * Classe com o objetivo de ser a respons�vel pelo gerenciamento de todas as 
 * telas da aplica��o, de sua inicializa��o � sua finaliza��o. Idealmente a 
 * classe principal BibliotecaPessoal.java se comunicar� exclusivamente com
 * esta e n�o diretamente com cada tela.
 */
public class GerenciadorDeTelas {
    
    private LivrosRepository livrosRepository;
    private UsuariosRepository usuariosRepository;
    
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
