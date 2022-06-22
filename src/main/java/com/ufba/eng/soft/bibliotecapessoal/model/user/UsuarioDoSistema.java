
package com.ufba.eng.soft.bibliotecapessoal.model.user;


public abstract class UsuarioDoSistema {
    private String idUsuario;
    private String nomeDeUusario;
    private String userName;
    private String senha;
    private String debito;
    private String emprestimo;
    private String reserva;
    private ArrayList<Livro> livrosReservados;

    public UsuarioDoSistema(String idUsuario, String nomeDeUusario, String userName, String senha) {
        this.idUsuario = idUsuario;
        this.nomeDeUusario = nomeDeUusario;
        this.userName = userName;
        this.senha = senha;
        this.debito = "Não";
        this.emprestimo = "Não";
        this.reserva = "Não";
        this.livrosReservados = new ArrayList<>();
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

    public void setLivrosReservados(Livro livro) {
        this.livrosReservados.add(livro);
        System.out.println("Log: Adicionando livro em lista de reserva: " + this.livrosReservados.get(0)); // só pra teste
    }

    
    
    public abstract void consultarLivroIsbn();
    public abstract void consultarLivroPeloNome();
    public abstract void consultarLivroPeloCodBarra();
}


