package com.ufba.eng.soft.bibliotecapessoal.model.db;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Autor;
import com.ufba.eng.soft.bibliotecapessoal.model.product.GeneroLivro;
import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Aluno;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Professor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class LivroSQLiteOperationsTest {

    @Test
    void addLivroComSucesso() {
        LivroSQLiteOperations.removerLivroPorIsbn("4567");

        //Add Aluno:
        Aluno aluno = new Aluno("adohjfdsjixcbusuario", "Abraao", "abraao_01", "1234");
        UsuarioSQLiteOperations.addUsuario(aluno);

        //Add Livro:
        Livro livro = new Livro("Alice No Pais das Maravilhas", "4567", "4567", new Autor(9, "L. Carrol"), GeneroLivro.INFANTO_JUVENIL, 10);
        livro.setAlunosReserva(aluno);
        assertTrue(LivroSQLiteOperations.addLivro(livro));
        //Recuperar Livro:
        Livro livroEncontrado = LivroSQLiteOperations.getLivroByIsbn("4567");
        assertEquals(livro, livroEncontrado);
        //Recuperar Livro em Todos os Livros:
        assertTrue(LivroSQLiteOperations.getTodosOsLivros().contains(livro));
        //Modificar Livro:
        livro.setGenero(GeneroLivro.FANTASIA);
        livro.setAlunosReservaList(new ArrayList<>());
        Professor professor = new Professor("professorfvgjkldshdfs", "José Felipe", "jose_f_01", "2345");
        UsuarioSQLiteOperations.addUsuario(professor);
        livro.setProfessoresReserva(professor);
        assertTrue(LivroSQLiteOperations.atualizarLivro(livro));
        livroEncontrado = LivroSQLiteOperations.getLivroByIsbn("4567");
        assertEquals(livro, livroEncontrado);
        //Apagar Livro:
        LivroSQLiteOperations.removerLivroPorIsbn("4567");

        //Apagar Aluno:
        UsuarioSQLiteOperations.removerUsuarioPorId("adohjfdsjixcbusuario");
    }

    @Test
    void getLivroComTituloParcial() {

        //Add Aluno:
        String idUsuario = UUID.randomUUID().toString();
        Aluno aluno = new Aluno(idUsuario, "Abraao", "abraao_01", "1234");
        UsuarioSQLiteOperations.addUsuario(aluno);

        //Add Livro:
        String codigoISBN = String.valueOf(new Random().nextInt());
        Livro livro = new Livro("Alice No Pais das Maravilhas", codigoISBN, "4567", new Autor(9, "L. Carrol"), GeneroLivro.INFANTO_JUVENIL, 10);
        livro.setAlunosReserva(aluno);
        assertTrue(LivroSQLiteOperations.addLivro(livro));

        //Assertions:

        List<Livro> livrosEncontrados = LivroSQLiteOperations.getLivrosByTituloParcial("Alice");
        assertTrue(livrosEncontrados.contains(livro));

        livrosEncontrados = LivroSQLiteOperations.getLivrosByTituloParcial("Maravilhas");
        assertTrue(livrosEncontrados.contains(livro));

        livrosEncontrados = LivroSQLiteOperations.getLivrosByTituloParcial("Pais");
        assertTrue(livrosEncontrados.contains(livro));

        livrosEncontrados = LivroSQLiteOperations.getLivrosByTituloParcial("Maria");
        assertFalse(livrosEncontrados.contains(livro));

        //Remover Livro:
        LivroSQLiteOperations.removerLivroPorIsbn(codigoISBN);

        //Remover Usuario:
        UsuarioSQLiteOperations.removerUsuarioPorId(idUsuario);

    }
}