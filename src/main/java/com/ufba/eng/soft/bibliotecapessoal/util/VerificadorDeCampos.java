package com.ufba.eng.soft.bibliotecapessoal.util;

public class VerificadorDeCampos {
    
    private VerificadorDeCampos () {
        //Intencionalmente deixado vazio
    }
    
    public static ResultadoVerificacao nome(String nome) {
        if (nome == null || nome.isEmpty()) {
            return new ResultadoVerificacao(false, "Campo Nome n�o  pode estar vazio.");
        }
        if (!nome.matches("[a-zA-Z].+")) {
            return new ResultadoVerificacao(false, "Insira nome, Formato: Letras(mai�sculas e/ou min�sculas), sem caracteres especiais ou acentua��o.");
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao sobrenome(String sobrenome) {
        if (sobrenome == null || sobrenome.isEmpty()) {
            return new ResultadoVerificacao(false, "Campo Sobrenome n�o pode estar vazio.");
        }
        if (!sobrenome.matches("[a-zA-Z].+")) {
            return new ResultadoVerificacao(false, "Insira Sobrenome, Formato: Letras(mai�sculas e/ou min�sculas), sem caracteres especiais ou acentua��o.");
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao idUsuario(String idUsuario) {
        if (idUsuario == null || idUsuario .isEmpty()){
            return new ResultadoVerificacao(false, "Campo ID n�o  pode estar vazio.");
        }
        if (idUsuario.length() != 6 || !idUsuario .matches("ID[0-9]+")){
            return new ResultadoVerificacao(false, "Insira o id do usu�rio, Formato: Inicial 'ID' seguidas de 4 d�gitos, sem caracteres especiais, sem espa�os."); 
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao userName(String userName) {
        if (userName == null || userName.isEmpty()){
            return new ResultadoVerificacao(false, "Campo Username n�o pode estar vazio");
        }
        if(userName.length() < 4 || userName.length() > 10 || !userName.matches("[a-zA-Z]+")){
            return new ResultadoVerificacao(false, "Insira o Username, Formato: De 4 a 10 Letras (mai�sculas e/ou min�sculas), sem caracteres especiais ou acentua��o, sem espa�os.");
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao senha(String senha) {
        if (senha == null || senha .isEmpty()){
            return new ResultadoVerificacao(false, "Campo senha n�o  pode estar vazio");
        }
        if(senha.length() != 8 || !senha .matches("[0-9]+")){
           return new ResultadoVerificacao(false, "Insira a senha. Formato: 8 d�gitos num�ricos.");
        }
        return new ResultadoVerificacao(true);
    }
    
    //Acrescentar verifica��o de demais campos
    
    //Verifica��o campos cadastro de livros
    public static ResultadoVerificacao titulo(String titulo) {
        if (titulo == null || titulo.isEmpty()){
            return new ResultadoVerificacao(false, "Campo t�tulo n�o pode estar vazio.");
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao autor(String autor) {
        if (autor == null || autor.isEmpty()){
            return new ResultadoVerificacao(false, "Campo autor n�o  pode estar vazio.");
        }
        if (!autor.matches("[a-zA-Z].+ [a-zA-Z].+")) {
            return new ResultadoVerificacao(false, "Insira nome e sobrenome do autor. Formato: Letras(mai�sculas e/ou min�sculas), sem caracteres especiais ou acentua��o");
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao idAutor(String idAutor) {
        if (idAutor == null || idAutor .isEmpty()) {
            return new ResultadoVerificacao(false, "Campo ID-Autor(a) n�o  pode estar vazio.");
        }        
        if (idAutor.length() != 6 || !idAutor .matches("ID[0-9]+")){
            return new ResultadoVerificacao(false, "Insira o ID-Autor(a), Formato: Inicial 'ID' seguidas de 4 d�gitos, sem caracteres especiais, sem espa�os.");
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao isbn(String isbn) {
        if (isbn == null || isbn .isEmpty()) {
            return new ResultadoVerificacao(false, "Insira um v�lor num�rico (4 a 13 d�gitos) no campo ISBN.");
        }
        if (isbn.length() < 4 || isbn.length() > 13 || !isbn .matches("[0-9]+")){
                return new ResultadoVerificacao(false, "Insira o ISBN, Formato: de 4 a 13 d�gitos num�ricos, sem caracteres especiais, sem espa�os.");  
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao codDeBarra(String codDeBarra) {
        if (codDeBarra == null || codDeBarra .isEmpty()) {
            return new ResultadoVerificacao(false, "Campo C�d. De Barra n�o pode estar vazio.");
        }
        if(codDeBarra.length() != 10 || !codDeBarra .matches("[0-9]+")){
            return new ResultadoVerificacao(false, "Insira o c�digo de barra do livro, Formato: 10 d�gitos, sem espa�os.");
        }        
        return new ResultadoVerificacao(true);
    }

    public static ResultadoVerificacao copias(String qtdCopias) {
        if (qtdCopias == null || qtdCopias.isEmpty()) {
            return new ResultadoVerificacao(false, "Quantidade de c�pias n�o pode estar vazio");
        }
        if (!qtdCopias.matches("[0-9]+")) {
            return new ResultadoVerificacao(false, "Insira uma quantidade de c�pias v�lida: 0 ou mais, somente d�gitos.");
        }
        return new ResultadoVerificacao(true);
    }
}
