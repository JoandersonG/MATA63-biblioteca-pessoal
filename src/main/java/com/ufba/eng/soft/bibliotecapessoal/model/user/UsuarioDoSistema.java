
package com.ufba.eng.soft.bibliotecapessoal.model.user;


public abstract class UsuarioDoSistema {
    private String idUsuario;
    private String nomeDeUusario;
    private String sobrenomeDeUsuario;
    private String userName;
    private String senha;

    public UsuarioDoSistema(String idUsuario, String nomeDeUusario, String sobrenomeDeUsuario, String userName, String senha) {
        this.idUsuario = idUsuario;
        this.nomeDeUusario = nomeDeUusario;
        this.sobrenomeDeUsuario = sobrenomeDeUsuario;
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

    public String getUltimoSobrenomeDeUsuario() {
        return sobrenomeDeUsuario;
    }

    public void setUltimoSobrenomeDeUsuario(String sobrenomeDeUsuario) {
        this.sobrenomeDeUsuario = sobrenomeDeUsuario;
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

    
    
    public abstract void consultarLivroIsbn();
    public abstract void consultarLivroPeloNome();
    public abstract void consultarLivroPeloCodBarra();
}


