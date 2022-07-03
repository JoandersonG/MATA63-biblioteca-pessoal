
package com.ufba.eng.soft.bibliotecapessoal.model.user;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import java.util.ArrayList;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
public class Administrador extends UsuarioDoSistema {
    
     private ArrayList<Livro> livrosEmprestados = new ArrayList<>();
    
    public Administrador(String idUsuario, String nomeDeUusario, String userName, String senha) {
        super(idUsuario, nomeDeUusario, userName, senha);
    }

    public Administrador(String idUsuario, String nomeDeUusario, String userName, String senha, String debito, String emprestimo, String reserva) {
        super(idUsuario, nomeDeUusario, userName, senha, debito, emprestimo, reserva);
    }

    public Administrador() {
        super();
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
    
    public void consultarUsuarioPeloNome() {
        
    }
    
    public void consultarUsuarioPeloId() {
        
    }
    
    public void cadastrarUsuario() {
        
    }
    
    public void atualizarUsuario() {
        
    }
    
    public void removerUsuario() {
        
    }
    
    public void cadastrarLivro() {
        
    }
    
    public void atualizarLivro() {
        
    }
    
    public void removerLivro() {
        
    }
    
    public void consultarReserva() {
        
    }
    
    public void consultarEmprestimo() {
        
    }
    
    public void definirRegrasDeEmprestimo() {
        
    }
    
    public void gerenciarEtiquetas() {
        
    }

}
