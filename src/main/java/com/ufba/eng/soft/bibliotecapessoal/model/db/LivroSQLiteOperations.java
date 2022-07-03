package com.ufba.eng.soft.bibliotecapessoal.model.db;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Autor;
import com.ufba.eng.soft.bibliotecapessoal.model.product.GeneroLivro;
import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Aluno;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Orientando;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Professor;
import com.ufba.eng.soft.bibliotecapessoal.model.user.UsuarioDoSistema;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public class LivroSQLiteOperations {

    private LivroSQLiteOperations() {
    }

    public static boolean addLivro(Livro livro) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            for (Aluno aluno : livro.getAlunosReserva()) {
                ReservaSQLiteOperations.inserirReservaSeNaoExistir(Integer.parseInt(livro.getCodigoISBN()), aluno.getIdUsuario());
            }
            for (Professor professor : livro.getProfessoresReserva()) {
                ReservaSQLiteOperations.inserirReservaSeNaoExistir(Integer.parseInt(livro.getCodigoISBN()), professor.getIdUsuario());
            }
            for (Orientando orientando : livro.getOrientandosReserva()) {
                ReservaSQLiteOperations.inserirReservaSeNaoExistir(Integer.parseInt(livro.getCodigoISBN()), orientando.getIdUsuario());
            }
            for (Aluno aluno : livro.getAlunosEmprestimo()) {
                EmprestimoSQLiteOperations.inserirEmprestimoSeNaoExistir(Integer.parseInt(livro.getCodigoISBN()), aluno.getIdUsuario());
            }
            for (Professor professor : livro.getProfessoresEmprestimo()) {
                EmprestimoSQLiteOperations.inserirEmprestimoSeNaoExistir(Integer.parseInt(livro.getCodigoISBN()), professor.getIdUsuario());
            }
            for (Orientando orientando : livro.getOrientandosEmprestimo()) {
                EmprestimoSQLiteOperations.inserirEmprestimoSeNaoExistir(Integer.parseInt(livro.getCodigoISBN()), orientando.getIdUsuario());
            }
            StringBuilder query = new StringBuilder();
            query.append("INSERT INTO LIVROS( NOME, ISBN, COD_BARRAS, AUTOR_ID, AUTOR_NOME, GENERO_LIVRO, TOTAL_COPIAS, EMPRESTADO, RESERVADO ) ")
                    .append("VALUES (")
                    .append("'").append(livro.getNomeDoLivro()).append("', ")
                    .append(livro.getCodigoISBN()).append(", ")
                    .append("'").append(livro.getCodigoDeBarras()).append("', ")
                    .append(livro.getAutor().getId()).append(", ")
                    .append("'").append(livro.getAutor().getNome()).append("', ")
                    .append("'").append(livro.getGenero().toString()).append("', ")
                    .append(livro.getTotalCopias()).append(", ")
                    .append(livro.isEmprestado() ? "1, " : "0, ")
                    .append(livro.getReservado() ? "1" : "0")
                    .append(")");
            System.out.println(query);
            return connection.prepareStatement(query.toString()).executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. " + e.getMessage());
            return false;
        }
    }

    public static List<Livro> getTodosOsLivros() {
        ArrayList<Livro> livros = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            ResultSet resultSet = connection.prepareStatement("select * from LIVROS").executeQuery();
            while (resultSet.next()) {
                livros.add(getLivroFromQuery(resultSet, isbn -> {
                    try {
                        String sql = "select * from RESERVA where ISBN = " + isbn;
                        System.out.println(sql);
                        return connection.prepareStatement(sql).executeQuery();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        return null;
                    }
                }, isbn -> {
                    try {
                        String sql = "select * from EMPRESTIMO where ISBN = " + isbn;
                        System.out.println(sql);
                        return connection.prepareStatement(sql).executeQuery();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        return null;
                    }
                }));
            }
            System.out.println(livros);
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. Não foi possível recuperar dados." + e.getMessage());
        }
        return livros;
    }


    public static Livro getLivroByIsbn(String isbn) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            String sql = "select * from LIVROS WHERE ISBN = " + isbn;
            PreparedStatement stmt = connection.prepareStatement(sql);
            System.out.println(sql);
            ResultSet livrosResultSet = stmt.executeQuery();

            return livrosResultSet.next() ? getLivroFromQuery(livrosResultSet, innerIsbn -> {
                try {
                    String sql1 = "select * from RESERVA WHERE ISBN = " + innerIsbn;
                    System.out.println(sql1);
                    return connection.prepareStatement(sql1).executeQuery();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    return null;
                }
            }, innerIsbn -> {
                try {
                    String sql1 = "select * from EMPRESTIMO WHERE ISBN = " + innerIsbn;
                    System.out.println(sql1);
                    return connection.prepareStatement(sql1).executeQuery();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    return null;
                }
            }) : null;
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. Não foi possível recuperar dados." + e.getMessage());
            return null;
        }
    }

    private static Livro getLivroFromQuery(ResultSet livroResultSet, Function<Integer, ResultSet> getReservas, Function<Integer, ResultSet> getEmprestimos) throws SQLException {
        Optional<GeneroLivro> genero = GeneroLivro.getFromValue(livroResultSet.getString("GENERO_LIVRO"));
        Autor autor = new Autor(livroResultSet.getInt("AUTOR_ID"), livroResultSet.getString("AUTOR_NOME"));
        ArrayList<Aluno> reservasAluno = new ArrayList<>();
        ArrayList<Orientando> reservasOrientando = new ArrayList<>();
        ArrayList<Professor> reservasProfessor = new ArrayList<>();

        ResultSet reservasResultSet = getReservas.apply(livroResultSet.getInt("ISBN"));
        while (reservasResultSet.next()) {
            UsuarioDoSistema usuario = UsuarioSQLiteOperations.getUsuarioFromId(reservasResultSet.getString("ID_USUARIO"));
            if (usuario instanceof Aluno) {
                reservasAluno.add((Aluno) usuario);
            } else if (usuario instanceof Orientando) {
                reservasOrientando.add((Orientando) usuario);
            } else if (usuario instanceof Professor) {
                reservasProfessor.add((Professor) usuario);
            }
        }

        ArrayList<Aluno> emprestimosAluno = new ArrayList<>();
        ArrayList<Orientando> emprestimosOrientando = new ArrayList<>();
        ArrayList<Professor> emprestimosProfessor = new ArrayList<>();
        ResultSet emprestimosResultSet = getEmprestimos.apply(livroResultSet.getInt("ISBN"));
        while (emprestimosResultSet.next()) {
            UsuarioDoSistema usuario = UsuarioSQLiteOperations.getUsuarioFromId(emprestimosResultSet.getString("ID_USUARIO"));
            if (usuario instanceof Aluno) {
                emprestimosAluno.add((Aluno) usuario);
            } else if (usuario instanceof Orientando) {
                emprestimosOrientando.add((Orientando) usuario);
            } else if (usuario instanceof Professor) {
                emprestimosProfessor.add((Professor) usuario);
            }
        }

        return new Livro(
                livroResultSet.getString("NOME"),
                String.valueOf(livroResultSet.getInt("ISBN")),
                livroResultSet.getString("COD_BARRAS"),
                autor,
                genero.orElse(GeneroLivro.DESCONHECIDO),
                livroResultSet.getInt("TOTAL_COPIAS"),
                livroResultSet.getInt("EMPRESTADO") == 1,
                livroResultSet.getInt("RESERVADO") == 1,
                reservasAluno,
                reservasProfessor,
                reservasOrientando,
                emprestimosAluno,
                emprestimosProfessor,
                emprestimosOrientando
        );
    }

    public static boolean removerLivroPorIsbn(String isbn) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            ReservaSQLiteOperations.removerTodasAsReservasParaLivro(isbn);
            EmprestimoSQLiteOperations.removerTod0sOsEmprestimosParaLivro(isbn);
            String sql = "delete from LIVROS WHERE ISBN = " + isbn;
            System.out.println(sql);
            return connection.prepareStatement(sql).executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. Não foi possível recuperar dados." + e.getMessage());
            return false;
        }
    }

    public static boolean atualizarLivro(Livro paraAtualizar) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            Livro livro = getLivroByIsbn(paraAtualizar.getCodigoISBN());
            if (livro == null) {
                return false;
            }
            atualizarReservas(livro, paraAtualizar);
            atualizarEmprestimos(livro, paraAtualizar);
            StringBuilder query = new StringBuilder();
            query.append("update LIVROS set ")
                    .append("NOME = '").append(paraAtualizar.getNomeDoLivro()).append("', ")
                    .append("COD_BARRAS = '").append(paraAtualizar.getCodigoDeBarras()).append("', ")
                    .append("AUTOR_ID = ").append(paraAtualizar.getAutor().getId()).append(", ")
                    .append("AUTOR_NOME = '").append(paraAtualizar.getAutor().getNome()).append("', ")
                    .append("GENERO_LIVRO = '").append(paraAtualizar.getGenero().toString()).append("', ")
                    .append("TOTAL_COPIAS = ").append(paraAtualizar.getTotalCopias()).append(", ")
                    .append("EMPRESTADO = ").append(paraAtualizar.isEmprestado() ? "1, " : "0, ")
                    .append("RESERVADO = ").append(paraAtualizar.getReservado() ? "1 " : "0 ")
                    .append("where ISBN = ").append(paraAtualizar.getCodigoISBN());
            System.out.println(query);
            return connection.prepareStatement(query.toString()).executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. " + e.getMessage());
            return false;
        }
    }

    private static void atualizarEmprestimos(Livro livroAntes, Livro livroAtual) throws SQLException {
        EmprestimoSQLiteOperations.removerTod0sOsEmprestimosParaLivro(livroAntes.getCodigoISBN());
        for (Aluno aluno : livroAtual.getAlunosEmprestimo()) {
            EmprestimoSQLiteOperations.inserirEmprestimoSeNaoExistir(Integer.parseInt(livroAtual.getCodigoISBN()), aluno.getIdUsuario());
        }
        for (Professor professor : livroAtual.getProfessoresEmprestimo()) {
            EmprestimoSQLiteOperations.inserirEmprestimoSeNaoExistir(Integer.parseInt(livroAtual.getCodigoISBN()), professor.getIdUsuario());
        }
        for (Orientando orientando : livroAtual.getOrientandosEmprestimo()) {
            EmprestimoSQLiteOperations.inserirEmprestimoSeNaoExistir(Integer.parseInt(livroAtual.getCodigoISBN()), orientando.getIdUsuario());
        }
    }

    private static void atualizarReservas(Livro livroAntes, Livro livroAtual) throws SQLException {
        ReservaSQLiteOperations.removerTodasAsReservasParaLivro(livroAntes.getCodigoISBN());
        for (Aluno aluno : livroAtual.getAlunosReserva()) {
            ReservaSQLiteOperations.inserirReservaSeNaoExistir(Integer.parseInt(livroAtual.getCodigoISBN()), aluno.getIdUsuario());
        }
        for (Professor professor : livroAtual.getProfessoresReserva()) {
            ReservaSQLiteOperations.inserirReservaSeNaoExistir(Integer.parseInt(livroAtual.getCodigoISBN()), professor.getIdUsuario());
        }
        for (Orientando orientando : livroAtual.getOrientandosReserva()) {
            ReservaSQLiteOperations.inserirReservaSeNaoExistir(Integer.parseInt(livroAtual.getCodigoISBN()), orientando.getIdUsuario());
        }
    }

    public static List<Livro> getLivrosByTituloParcial(String tituloParcial) {
        ArrayList<Livro> livros = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            String sql = "select * from LIVROS where NOME like '%" + tituloParcial + "%'";
            System.out.println(sql);
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                livros.add(getLivroFromQuery(resultSet, isbn -> {
                    try {
                        String sql1 = "select * from RESERVA where ISBN = " + isbn;
                        System.out.println(sql1);
                        return connection.prepareStatement(sql1).executeQuery();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        return null;
                    }
                }, isbn -> {
                    try {
                        String sql1 = "select * from EMPRESTIMO where ISBN = " + isbn;
                        System.out.println(sql1);
                        return connection.prepareStatement(sql1).executeQuery();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        return null;
                    }
                }));
            }
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. Não foi possível recuperar dados." + e.getMessage());
        }
        return livros;
    }

    public static Livro getLivroByCodBarras(String codBarras) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            String sql = "select * from LIVROS where COD_BARRAS = '" + codBarras + "'";
            System.out.println(sql);
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet livrosResultSet = stmt.executeQuery();

            return livrosResultSet.next() ? getLivroFromQuery(livrosResultSet, innerIsbn -> {
                try {
                    String sql1 = "select * from RESERVA where ISBN = " + innerIsbn;
                    System.out.println(sql1);
                    return connection.prepareStatement(sql1).executeQuery();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    return null;
                }
            }, innerIsbn -> {
                try {
                    String sql1 = "select * from EMPRESTIMO where ISBN = " + innerIsbn;
                    System.out.println(sql1);
                    return connection.prepareStatement(sql1).executeQuery();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    return null;
                }
            }) : null;
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. Não foi possível recuperar dados." + e.getMessage());
            return null;
        }
    }
}
