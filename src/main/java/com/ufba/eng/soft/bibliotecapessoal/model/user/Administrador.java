
package com.ufba.eng.soft.bibliotecapessoal.model.user;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import java.util.ArrayList;


public class Administrador extends UsuarioDoSistema {
    
     private ArrayList<Livro> livrosEmprestados = new ArrayList<>();
    
    public Administrador(String idUsuario, String nomeDeUusario, String userName, String senha) {
        super(idUsuario, nomeDeUusario, userName, senha);
    }

    public Administrador() {
        super();
    }
    
     @Override
    public boolean consultarLivroEmprestado(Livro livro) {
        if(livrosEmprestados.contains(livro)){
            System.out.println("sim");
            return true;
        }
        System.out.println("nao");
        return false;
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

    @Override
    public void addLivroListaEmprestimos(Livro livro) {
         if(this.livrosEmprestados == null){
            this.livrosEmprestados = new ArrayList<>();
        }
        livrosEmprestados.add(livro);
    }

    @Override
    public void realizarDevolucao(Livro livro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
