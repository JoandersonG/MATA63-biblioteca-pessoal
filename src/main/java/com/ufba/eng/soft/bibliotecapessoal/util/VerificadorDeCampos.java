package com.ufba.eng.soft.bibliotecapessoal.util;

public class VerificadorDeCampos {
    
    private VerificadorDeCampos () {
        //Intencionalmente deixado vazio
    }
    
    public static ResultadoVerificacao nome(String nome) {
        if (nome == null || nome.isEmpty()) {
            return new ResultadoVerificacao(false, "Campo Nome não  pode estar vazio.");
        }
        if (!nome.matches("[a-zA-Z].+")) {
            return new ResultadoVerificacao(false, "Insira nome, Formato: Letras(maiúsculas e/ou minúsculas), sem caracteres especiais ou acentuação.");
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao sobrenome(String sobrenome) {
        if (sobrenome == null || sobrenome.isEmpty()) {
            return new ResultadoVerificacao(false, "Campo Sobrenome não pode estar vazio.");
        }
        if (!sobrenome.matches("[a-zA-Z].+")) {
            return new ResultadoVerificacao(false, "Insira Sobrenome, Formato: Letras(maiúsculas e/ou minúsculas), sem caracteres especiais ou acentuação.");
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao idUsuario(String idUsuario) {
        if (idUsuario == null || idUsuario .isEmpty()){
            return new ResultadoVerificacao(false, "Campo ID não  pode estar vazio.");
        }
        if (idUsuario.length() != 6 || !idUsuario .matches("ID[0-9]+")){
            return new ResultadoVerificacao(false, "Insira o id do usuário, Formato: Inicial 'ID' seguidas de 4 dígitos, sem caracteres especiais, sem espaços."); 
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao userName(String userName) {
        if (userName == null || userName.isEmpty()){
            return new ResultadoVerificacao(false, "Campo Username não pode estar vazio");
        }
        if(userName.length() < 4 || userName.length() > 10 || !userName.matches("[a-zA-Z]+")){
            return new ResultadoVerificacao(false, "Insira o Username, Formato: De 4 a 10 Letras (maiúsculas e/ou minúsculas), sem caracteres especiais ou acentuação, sem espaços.");
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao senha(String senha) {
        if (senha == null || senha .isEmpty()){
            return new ResultadoVerificacao(false, "Campo senha não  pode estar vazio");
        }
        if(senha.length() != 8 || !senha .matches("[0-9]+")){
           return new ResultadoVerificacao(false, "Insira a senha. Formato: 8 dígitos numéricos.");
        }
        return new ResultadoVerificacao(true);
    }
    
    //Acrescentar verificação de demais campos
    
    //Verificação campos cadastro de livros
    public static ResultadoVerificacao titulo(String titulo) {
        if (titulo == null || titulo.isEmpty()){
            return new ResultadoVerificacao(false, "Campo título não pode estar vazio.");
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao autor(String autor) {
        if (autor == null || autor.isEmpty()){
            return new ResultadoVerificacao(false, "Campo autor não  pode estar vazio.");
        }
        if (!autor.matches("[a-zA-Z].+ [a-zA-Z].+")) {
            return new ResultadoVerificacao(false, "Insira nome e sobrenome do autor. Formato: Letras(maiúsculas e/ou minúsculas), sem caracteres especiais ou acentuação");
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao idAutor(String idAutor) {
        if (idAutor == null || idAutor .isEmpty()) {
            return new ResultadoVerificacao(false, "Campo ID-Autor(a) não  pode estar vazio.");
        }        
        if (idAutor.length() != 6 || !idAutor .matches("ID[0-9]+")){
            return new ResultadoVerificacao(false, "Insira o ID-Autor(a), Formato: Inicial 'ID' seguidas de 4 dígitos, sem caracteres especiais, sem espaços.");
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao isbn(String isbn) {
        if (isbn == null || isbn .isEmpty()) {
            return new ResultadoVerificacao(false, "Insira um válor numérico (4 a 13 dígitos) no campo ISBN.");
        }
        if (isbn.length() < 4 || isbn.length() > 13 || !isbn .matches("[0-9]+")){
                return new ResultadoVerificacao(false, "Insira o ISBN, Formato: de 4 a 13 dígitos numéricos, sem caracteres especiais, sem espaços.");  
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao codDeBarra(String codDeBarra) {
        if (codDeBarra == null || codDeBarra .isEmpty()) {
            return new ResultadoVerificacao(false, "Campo Cód. De Barra não pode estar vazio.");
        }
        if(codDeBarra.length() != 10 || !codDeBarra .matches("[0-9]+")){
            return new ResultadoVerificacao(false, "Insira o código de barra do livro, Formato: 10 dígitos, sem espaços.");
        }        
        return new ResultadoVerificacao(true);
    }
    
}
