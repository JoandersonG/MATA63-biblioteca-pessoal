/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.model.product;

import com.ufba.eng.soft.bibliotecapessoal.model.user.Aluno;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Orientando;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Professor;
import com.ufba.eng.soft.bibliotecapessoal.model.user.UsuarioDoSistema;
import java.util.ArrayList;
import lombok.Data;

//Falta incluir etiqueta

@Data
public class Livro {
    private String nomeDoLivro;
    //private Etiqueta etiqueta;
    private String codigoISBN;
    private String codigoDeBarras;
    private String autor;
    public GeneroLivro genero;
    private boolean emprestado = false;
    private boolean reservado = false;
    private ArrayList<Aluno> alunosReserva;
    private ArrayList<Professor> professoresReserva;
    private ArrayList<Orientando> orientandosReserva;
    private ArrayList<Aluno> alunosEmprestimo;
    private ArrayList<Professor> professoresEmprestimo;
    private ArrayList<Orientando> orientandosEmprestimo;

    public Livro(String nomeDoLivro, String codigoISBN, String codigoDeBarras, String autor, GeneroLivro genero) {
        this.nomeDoLivro = nomeDoLivro;
        this.codigoISBN = codigoISBN;
        this.codigoDeBarras = codigoDeBarras;
        this.autor = autor;
        this.genero = genero;
        this.alunosReserva = new ArrayList<>();
        this.professoresReserva = new ArrayList<>();
        this.orientandosReserva = new ArrayList<>();
        this.alunosEmprestimo = new ArrayList<>();
        this.professoresEmprestimo = new ArrayList<>();
        this.orientandosEmprestimo = new ArrayList<>();
    }

    public Livro() {
        
    }

    
    
    public boolean getReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }
    
    public boolean getEmprestadoo() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado, UsuarioDoSistema usuario, String tipoUsuario) {
        this.emprestado = emprestado;
        
        if(this.emprestado){
            if ("Aluno".equals(tipoUsuario)){
                this.alunosEmprestimo.add((Aluno) usuario);
            }
            if ("Professor".equals(tipoUsuario)){
                this.professoresEmprestimo.add((Professor) usuario);
            }
            if ("Orientando".equals(tipoUsuario)){
                this.orientandosEmprestimo.add((Orientando) usuario);
            }
        }
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

    public void addAlunosReserva(Aluno usuario) {
        this.alunosReserva.add(usuario);
    }
    
    public void addProfessoresReserva(Professor usuario) {
        this.professoresReserva.add(usuario);
    }
    
    public void addOrientandosReserva(Orientando usuario) {
        this.orientandosReserva.add(usuario);
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setAlunosReserva(ArrayList<Aluno> alunosReserva) {
        this.alunosReserva = alunosReserva;
    }

    public void setProfessoresReserva(ArrayList<Professor> professoresReserva) {
        this.professoresReserva = professoresReserva;
    }

    public void setOrientandosReserva(ArrayList<Orientando> orientandosReserva) {
        this.orientandosReserva = orientandosReserva;
    }
    
    
}
