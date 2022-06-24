
package com.ufba.eng.soft.bibliotecapessoal.model.user;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import java.util.ArrayList;


public abstract class UsuarioDoSistema {
    private String idUsuario;
    private String nomeDeUusario;
    private String userName;
    private String senha;
    private String debito;
    private String emprestimo;
    private String reserva;
    private ArrayList<Livro> livrosReservados;
    private ArrayList<Livro> livrosEmprestados;

    public UsuarioDoSistema(String idUsuario, String nomeDeUusario, String userName, String senha) {
        this.idUsuario = idUsuario;
        this.nomeDeUusario = nomeDeUusario;
        this.userName = userName;
        this.senha = senha;
        this.debito = "Não";
        this.emprestimo = "Não";
        this.reserva = "Não";
        this.livrosReservados = new ArrayList<>();
        this.livrosEmprestados = new ArrayList<>();
    }

    
    
    public UsuarioDoSistema(){
        
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeDeUusario() {
        return nomeDeUusario;
    }

    public void setNomeDeUusario(String nomeDeUusario) {
        this.nomeDeUusario = nomeDeUusario;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDebito() {
        return debito;
    }

    public void setDebito(String debito) {
        this.debito = debito;
    }

    public String getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(String emprestimo) {
        this.emprestimo = emprestimo;
    }

    public String getReserva() {
        return reserva;
    }

    public void setReserva(String reserva) {
        this.reserva = reserva;
    }

    public ArrayList<Livro> getLivrosReservados() {
        return livrosReservados;
    }

    public void setLivrosReservados(ArrayList<Livro> livrosReservados) {
        this.livrosReservados = livrosReservados;
    }

    public ArrayList<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(ArrayList<Livro> livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }

    
    public abstract void addLivroListaEmprestimos(Livro livro);
    public abstract void consultarLivroIsbn();
    public abstract void consultarLivroPeloNome();
    public abstract void consultarLivroPeloCodBarra();
}


