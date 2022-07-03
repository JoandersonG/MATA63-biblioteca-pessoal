
package com.ufba.eng.soft.bibliotecapessoal.model.user;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import java.util.ArrayList;


import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class UsuarioDoSistema {
    private String idUsuario;
    private String nomeDeUusario;
    private String userName;
    private String senha;
    private String debito;
    private String emprestimo;
    private String reserva;

    public UsuarioDoSistema(String idUsuario, String nomeDeUusario, String userName, String senha) {
        this.idUsuario = idUsuario;
        this.nomeDeUusario = nomeDeUusario;
        this.userName = userName;
        this.senha = senha;
        this.debito = "Não";
        this.emprestimo = "Não";
        this.reserva = "Não";
    }
/*
    public UsuarioDoSistema(String idUsuario, String nomeDeUusario, String userName, String senha, String debito, String emprestimo, String reserva) {
        this.idUsuario = idUsuario;
        this.nomeDeUusario = nomeDeUusario;
        this.userName = userName;
        this.senha = senha;
        this.debito = debito;
        this.emprestimo = emprestimo;
        this.reserva = reserva;
    }*/
    public abstract void addLivroListaEmprestimos(Livro livro);
    public abstract boolean consultarLivroEmprestado(Livro livro);
    public abstract void consultarLivroIsbn();
    public abstract void consultarLivroPeloNome();
    public abstract void consultarLivroPeloCodBarra();
    public abstract void realizarDevolucao(Livro livro);

}


