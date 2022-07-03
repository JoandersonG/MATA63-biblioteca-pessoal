
package com.ufba.eng.soft.bibliotecapessoal.model.user;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import java.util.ArrayList;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
public class Aluno extends UsuarioDoSistema {
    
     private ArrayList<Livro> livrosEmprestados = new ArrayList<>();

    public Aluno(String idUsuario, String nomeDeUusario, String userName, String senha) {
        super(idUsuario, nomeDeUusario, userName, senha);
    }

    public Aluno(String idUsuario, String nomeDeUusario, String userName, String senha, String debito, String emprestimo, String reserva) {
        super(idUsuario, nomeDeUusario, userName, senha, debito, emprestimo, reserva);
    }

    public Aluno() {
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
    
    public void realizarEmprestimo() {
        
    }
    
     @Override
    public void realizarDevolucao(Livro livro) {
        livrosEmprestados.remove(livro);
    }
    
    public void realizarReserva() {
        
    }

}
