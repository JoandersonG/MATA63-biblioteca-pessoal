
package com.ufba.eng.soft.bibliotecapessoal.model.user;


public class Orientando extends UsuarioDoSistema {

    public Orientando(String idUsuario, String nomeDeUusario, String userName, int senha) {
        super(idUsuario, nomeDeUusario, userName, senha);
    }

    @Override
    public void consultarLivroIsbn() {
        
    }

    @Override
    public void consultarLivroPeloNome() {
        
    }

    @Override
    public void consultarLivroPeloCodBarra() {
        
    }
    
    public void realizarEmprestimo() {
        
    }
    
    public void realizarDevolucao() {
        
    }
    
    public void realizarReserva() {
        
    }
    
}
