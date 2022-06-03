package com.ufba.eng.soft.bibliotecapessoal.front.view;

import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;
import java.io.IOException;

/**
 * Classe com o objetivo de ser a responsável pelo gerenciamento de todas as 
 * telas da aplicação, de sua inicialização à sua finalização. Idealmente a 
 * classe principal BibliotecaPessoal.java se comunicará exclusivamente com
 * esta e não diretamente com cada tela.
 */
public class GerenciadorDeTelas {
    
    private LivrosRepository livrosRepository;
    
    public GerenciadorDeTelas(LivrosRepository livrosRepository) {
       this.livrosRepository = livrosRepository;
    }
    
    public TelaPrincipalAdministrador inicializaTelaPrincipalAdministrador() throws IOException {
        TelaPrincipalAdministrador frame = new TelaPrincipalAdministrador();
        frame.setVisible(true);
        return frame;
    }
    
    public ConsultarLivroTelaPrincipal inicializaTelaPrincipal() {
        ConsultarLivroTelaPrincipal frame = new ConsultarLivroTelaPrincipal(livrosRepository);
	frame.setVisible(true);
        return frame;
    }
   
}
