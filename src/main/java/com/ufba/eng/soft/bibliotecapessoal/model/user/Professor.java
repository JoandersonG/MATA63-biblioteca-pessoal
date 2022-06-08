
package com.ufba.eng.soft.bibliotecapessoal.model.user;


public class Professor extends UsuarioDoSistema {

    public Professor(String idUsuario, String nomeDeUusario, String sobrenomeDeUsuario, String userName, String senha) {
        super(idUsuario, nomeDeUusario, sobrenomeDeUsuario, userName, senha);
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
