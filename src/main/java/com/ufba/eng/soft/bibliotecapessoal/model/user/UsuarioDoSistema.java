
package com.ufba.eng.soft.bibliotecapessoal.model.user;


public abstract class UsuarioDoSistema {
    private String idUsuario;
    private String nomeDeUusario;
    private String userName;
    private int senha;

    public UsuarioDoSistema(String idUsuario, String nomeDeUusario, String userName, int senha) {
        this.idUsuario = idUsuario;
        this.nomeDeUusario = nomeDeUusario;
        this.userName = userName;
        this.senha = senha;
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

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
    
    public abstract void consultarLivroIsbn();
    public abstract void consultarLivroPeloNome();
    public abstract void consultarLivroPeloCodBarra();
}


