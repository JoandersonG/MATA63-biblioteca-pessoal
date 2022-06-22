/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.model.product;

import lombok.Data;

//Falta incluir etiqueta

@Data
public class Livro {
    private String nomeDoLivro;
    //private Etiqueta etiqueta;
    private String codigoISBN;
    private String codigoDeBarras;
    private Autor autor;
    public GeneroLivro genero;
    private boolean emprestado = false;
    private boolean reservado = false;
    private ArrayList<Aluno> alunosReserva;
    private ArrayList<Professor> professoresReserva;
    private ArrayList<Orientando> orientandosReserva;

    public Livro(String nomeDoLivro, String codigoISBN, String codigoDeBarras, Autor autor, GeneroLivro genero) {
        this.nomeDoLivro = nomeDoLivro;
        this.codigoISBN = codigoISBN;
        this.codigoDeBarras = codigoDeBarras;
        this.autor = autor;
        this.genero = genero;
        this.alunosReserva = new ArrayList<>();
        this.professoresReserva = new ArrayList<>();
        this.orientandosReserva = new ArrayList<>();
    }
    
    public boolean getReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }
    
    public String getCodigoISBN() {
        return codigoISBN;
    }

    public void setCodigoISBN(String isbn) {
        this.codigoISBN = isbn;
    }
    
    public ArrayList<Aluno> getAlunosReserva() {
        return alunosReserva;
    }
    
    public ArrayList<Professor> getProfessoresReserva() {
        return professoresReserva;
    }
    
    public ArrayList<Orientando> getOrientandosReserva() {
        return orientandosReserva;
    }

    public void setAlunosReserva(Aluno usuario) {
        this.alunosReserva.add(usuario);
    }
    
    public void setProfessoresReserva(Professor usuario) {
        this.professoresReserva.add(usuario);
    }
    
    public void setOrientandosReserva(Orientando usuario) {
        this.orientandosReserva.add(usuario);
    }
    
}
