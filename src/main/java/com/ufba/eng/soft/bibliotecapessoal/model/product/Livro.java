/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.model.product;

import com.ufba.eng.soft.bibliotecapessoal.model.user.Aluno;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Orientando;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Professor;
import com.ufba.eng.soft.bibliotecapessoal.model.user.UsuarioDoSistema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Optional;

//Falta incluir etiqueta

@Data
@AllArgsConstructor
public class Livro {
    private String nomeDoLivro;
    //private Etiqueta etiqueta;
    private String codigoISBN;
    private String codigoDeBarras;
    private Autor autor;
    private GeneroLivro genero;
    private int totalCopias;
    private boolean emprestado = false;
    private boolean reservado = false;
    private ArrayList<Aluno> alunosReserva;
    private ArrayList<Professor> professoresReserva;
    private ArrayList<Orientando> orientandosReserva;
    private ArrayList<Aluno> alunosEmprestimo;
    private ArrayList<Professor> professoresEmprestimo;
    private ArrayList<Orientando> orientandosEmprestimo;

    public Livro(String nomeDoLivro, String codigoISBN, String codigoDeBarras, Autor autor, GeneroLivro genero, int totalCopias) {
        this.nomeDoLivro = nomeDoLivro;
        this.codigoISBN = codigoISBN;
        this.codigoDeBarras = codigoDeBarras;
        this.autor = autor;
        this.genero = genero;
        this.totalCopias = totalCopias;
        this.alunosReserva = new ArrayList<>();
        this.professoresReserva = new ArrayList<>();
        this.orientandosReserva = new ArrayList<>();
        this.alunosEmprestimo = new ArrayList<>();
        this.professoresEmprestimo = new ArrayList<>();
        this.orientandosEmprestimo = new ArrayList<>();
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
//todo: vamos usar esse método?
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

    public void setAlunosReserva(Aluno usuario) {
        this.alunosReserva.add(usuario);
    }

    public void setAlunosReservaList(ArrayList<Aluno> alunosReserva) {
        this.alunosReserva = alunosReserva;
    }

    public void setReserva(UsuarioDoSistema usuarioDoSistema) {
        if (usuarioDoSistema instanceof  Professor) {
            setProfessoresReserva((Professor) usuarioDoSistema);
        }
        if (usuarioDoSistema instanceof Orientando) {
            setOrientandosReserva((Orientando) usuarioDoSistema);
        }
        if (usuarioDoSistema instanceof Aluno) {
            setAlunosReserva((Aluno) usuarioDoSistema);
        }
    }

    public void setEmprestimo(UsuarioDoSistema usuarioDoSistema) {
        if (usuarioDoSistema instanceof  Professor) {
            addProfessoresEmprestimo((Professor) usuarioDoSistema);
        }
        if (usuarioDoSistema instanceof Orientando) {
            AddOrientandosEmprestimo((Orientando) usuarioDoSistema);
        }
        if (usuarioDoSistema instanceof Aluno) {
            AddAlunosEmprestimo((Aluno) usuarioDoSistema);
        }
    }

    private void AddAlunosEmprestimo(Aluno aluno) {
        this.alunosEmprestimo.add(aluno);
    }

    private void AddOrientandosEmprestimo(Orientando orientando) {
        this.orientandosEmprestimo.add(orientando);
    }

    private void addProfessoresEmprestimo(Professor professor) {
        this.professoresEmprestimo.add(professor);
    }

    public void setProfessoresReserva(Professor usuario) {
        this.professoresReserva.add(usuario);
    }
    
    public void setOrientandosReserva(Orientando usuario) {
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


    public boolean isReservadoPara(String idUsuario) {
        for (Aluno a : alunosReserva) {
            if(a.getIdUsuario().equals(idUsuario)) {
                return true;
            }
        }
        for (Professor p : professoresReserva) {
            if(p.getIdUsuario().equals(idUsuario)) {
                return true;
            }
        }
        for (Orientando orientando : orientandosReserva) {
            if(orientando.getIdUsuario().equals(idUsuario)) {
                return true;
            }
        }
        return false;
    }
    public boolean isEmprestadoPara(String idUsuario) {
        for (Aluno a : alunosEmprestimo) {
            if(a.getIdUsuario().equals(idUsuario)) {
                return true;
            }
        }
        for (Professor p : professoresEmprestimo) {
            if(p.getIdUsuario().equals(idUsuario)) {
                return true;
            }
        }
        for (Orientando orientando : orientandosEmprestimo) {
            if(orientando.getIdUsuario().equals(idUsuario)) {
                return true;
            }
        }
        return false;
    }


    public boolean temCopiasDisponiveisParaEmprestimo() {
        return totalCopias > alunosEmprestimo.size() + orientandosEmprestimo.size() + professoresEmprestimo.size();
    }
}
