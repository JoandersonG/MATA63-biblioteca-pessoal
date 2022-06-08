/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author joand
 */
public class VerificadorDeCampos {
    
    private VerificadorDeCampos () {
        //Intencionalmente deixado vazio
    }
    
    public static ResultadoVerificacao nome(String nome) {
        if (nome == null) {
            return new ResultadoVerificacao(false, "Campo Nome não  pode ser nulo.");
        }
        if (nome.isEmpty()){
            return new ResultadoVerificacao(false, "Campo Nome não pode estar vazio.");
        } else {
        }
        if (!nome.matches("[a-zA-Z].+")) {
            return new ResultadoVerificacao(false, "Insira nome, Formato: Letras(maiúsculas e/ou minúsculas), sem caracteres especiais ou acentuação.");
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao sobrenome(String sobrenome) {
        if (sobrenome == null) {
            return new ResultadoVerificacao(false, "Campo Sobrenome não  pode ser nulo.");
        }
        if (sobrenome.isEmpty()){
            return new ResultadoVerificacao(false, "Campo Sobrenome não pode estar vazio.");
        } else {
        }
        if (!sobrenome.matches("[a-zA-Z].+")) {
            return new ResultadoVerificacao(false, "Insira Sobrenome, Formato: Letras(maiúsculas e/ou minúsculas), sem caracteres especiais ou acentuação.");
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao idUsuario(String idUsuario) {
        if (idUsuario == null) {
            return new ResultadoVerificacao(false, "Campo ID não  pode ser nulo.");
        }
        if (idUsuario .isEmpty()){
            return new ResultadoVerificacao(false, "Campo ID não  pode estar vazio.");
        } else {
        }
        if (idUsuario.length() == 6){
           if (!idUsuario .matches("ID[0-9]+")) {
                return new ResultadoVerificacao(false, "Insira o id do usuário, Formato: Inicial 'ID' seguidas de 4 dígitos, sem caracteres especiais, sem espaços.");
            } 
        }
        else{
            return new ResultadoVerificacao(false, "Insira o id do usuário, Formato: Inicial 'ID' seguidas de 4 dígitos, sem caracteres especiais, sem espaços.");
        }
        
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao userName(String userName) {
        if (userName == null) {
            return new ResultadoVerificacao(false, "Campo Username não  pode ser nulo");
        }
        if (userName.isEmpty()){
            return new ResultadoVerificacao(false, "Campo Username não pode estar vazio");
        } else {
        }
        if(userName.length() >= 4 && userName.length() <= 10){
            if (!userName.matches("[a-zA-Z]+")) {
                return new ResultadoVerificacao(false, "Insira o Username, Formato: De 4 a 10 Letras (maiúsculas e/ou minúsculas), sem caracteres especiais ou acentuação, sem espaços.");
            }
        }
        else {
            return new ResultadoVerificacao(false, "Insira o Username, Formato: De 4 a 10 Letras (maiúsculas e/ou minúsculas), sem caracteres especiais ou acentuação, sem espaços.");
        }
        
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao senha(String senha) {
        if (senha == null) {
            return new ResultadoVerificacao(false, "Campo senha não  pode ser nulo");
        }
        if (senha .isEmpty()){
            return new ResultadoVerificacao(false, "Campo senha não  pode estar vazio");
        } else {
        }
        if(senha.length() == 8){
           if (!senha .matches("[0-9]+")) {
                return new ResultadoVerificacao(false, "Insira a senha. Formato: 8 dígitos, sem espaços.");
           } 
        }
        else{
           return new ResultadoVerificacao(false, "Insira a senha. Formato: 8 dígitos, sem espaços."); 
        }
        
        return new ResultadoVerificacao(true);
    }
    
    //Acrescentar verificação de demais campos
    
    //Verificação campos cadastro de livros
    public static ResultadoVerificacao titulo(String titulo) {
        if (titulo == null) {
            return new ResultadoVerificacao(false, "Campo título não pode ser nulo.");
        }
        if (titulo.isEmpty()){
            return new ResultadoVerificacao(false, "Campo título não pode estar vazio.");
        } else {
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao autor(String autor) {
        if (autor == null) {
            return new ResultadoVerificacao(false, "Campo autor não  pode ser nulo.");
        }
        if (autor.isEmpty()){
            return new ResultadoVerificacao(false, "Campo autor não  pode estar vazio.");
        } else {
        }
        if (!autor.matches("[a-zA-Z].+ [a-zA-Z].+")) {
            return new ResultadoVerificacao(false, "Insira nome e sobrenome do autor. Formato: Letras(maiúsculas e/ou minúsculas), sem caracteres especiais ou acentuação");
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao idAutor(String idAutor) {
        if (idAutor == null) {
            return new ResultadoVerificacao(false, "Campo ID-Autor(a) não  pode ser nulo.");
        }
        if (idAutor .isEmpty()){
            return new ResultadoVerificacao(false, "Campo ID-Autor(a) não  pode estar vazio.");
        } else {
        }
        if (idAutor.length() == 6){
           if (!idAutor .matches("ID[0-9]+")) {
                return new ResultadoVerificacao(false, "Insira o ID-Autor(a), Formato: Inicial 'ID' seguidas de 4 dígitos, sem caracteres especiais, sem espaços.");
            } 
        }
        else{
            return new ResultadoVerificacao(false, "Insira o ID-Autor(a), Formato: Inicial 'ID' seguidas de 4 dígitos, sem caracteres especiais, sem espaços.");
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao isbn(String isbn) {
        if (isbn == null) {
            return new ResultadoVerificacao(false, "Campo ISBN não  pode ser nulo.");
        }
        if (isbn .isEmpty()){
            return new ResultadoVerificacao(false, "Campo ISBN não  pode estar vazio.");
        } else {
        }
        if (isbn.length() == 8){
           if (!isbn .matches("ISBN[0-9]+")) {
                return new ResultadoVerificacao(false, "Insira o ISBN, Formato: Inicial 'ISBN' seguidas de 4 dígitos, sem caracteres especiais, sem espaços.");
            } 
        }
        else{
            return new ResultadoVerificacao(false, "Insira o ISBN, Formato: Inicial 'ID' seguidas de 4 dígitos, sem caracteres especiais, sem espaços.");
        }
        return new ResultadoVerificacao(true);
    }
    
    public static ResultadoVerificacao codDeBarra(String codDeBarra) {
        if (codDeBarra == null) {
            return new ResultadoVerificacao(false, "Campo Cód. De Barra não  pode ser nulo.");
        }
        if (codDeBarra .isEmpty()){
            return new ResultadoVerificacao(false, "Campo Cód. De Barra não  pode estar vazio.");
        } else {
        }
        if(codDeBarra.length() == 10){
            if (!codDeBarra .matches("[0-9]+")) {
                return new ResultadoVerificacao(false, "Insira o código de barra do livro, Formato: 10 dígitos, sem espaços.");
            }
        }
        else {
            return new ResultadoVerificacao(false, "Insira o código de barra do livro, Formato: 10 dígitos, sem espaços.");
        }
        
        return new ResultadoVerificacao(true);
    }
    
    
}
