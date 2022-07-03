package com.ufba.eng.soft.bibliotecapessoal.model.db;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import org.sqlite.SQLiteErrorCode;
import org.sqlite.SQLiteException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EmprestimoSQLiteOperations {

    private EmprestimoSQLiteOperations() {
    }


    static void inserirEmprestimoSeNaoExistir(int isbn, String idUsuario) throws SQLException {
        inserirEmprestimoSeNaoExistir(UUID.randomUUID().toString(), isbn, idUsuario);
    }
    static void inserirEmprestimoSeNaoExistir(String id, int isbn, String idUsuario) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO EMPRESTIMO(ID, ISBN, ID_USUARIO) VALUES ('"
                    + id + "', " + isbn + ", '" + idUsuario + "')";
            System.out.println(query);
            statement.execute(query);
        } catch (SQLiteException e) {
            if (e.getResultCode() != SQLiteErrorCode.SQLITE_CONSTRAINT) {
                System.out.println("LOG.error: Falha no banco de dados da aplicação. " + e.getMessage());
            }
        }
    }

    public static List<String> getTodosOsEmprestimos() {
        ArrayList<String> emprestimos = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            ResultSet resultSet = connection.prepareStatement("select * from EMPRESTIMO").executeQuery();
            while (resultSet.next()) {
                emprestimos.add(resultSet.getInt("ISBN") + " : " + resultSet.getString("ID_USUARIO"));
            }
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. Não foi possível recuperar dados." + e.getMessage());
        }
        return emprestimos;
    }

    public static void remover(int isbn, String idUsuario) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            String sql = "delete from EMPRESTIMO where ISBN = " + isbn + ", ID_USUARIO = '" + idUsuario + "'";
            connection.prepareStatement(sql).executeUpdate();
            System.out.println(sql);
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. Não foi possível recuperar dados." + e.getMessage());
        }
    }

    public static void removerTod0sOsEmprestimosParaLivro(String isbn) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            String sql = "delete from EMPRESTIMO where ISBN = " + isbn;
            System.out.println(sql);
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. Não foi possível recuperar dados." + e.getMessage());
        }
    }

    public static void removerTod0sOsEmprestimosParaUsuario(String idUsuario) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            String sql = "delete from EMPRESTIMO where ID_USUARIO = '" + idUsuario + "'";
            System.out.println(sql);
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. Não foi possível recuperar dados." + e.getMessage());
        }
    }

    public static List<String> getTodosOsEmprestimosParaUsuario(String id) {
        ArrayList<String> isbnsLivros = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            String sql = "select * from EMPRESTIMO where ID_USUARIO = '" + id + "'";
            System.out.println(sql);
            ResultSet resultSet = connection.prepareStatement(sql).executeQuery();
            while (resultSet.next()) {
                isbnsLivros.add("" + resultSet.getInt("ISBN"));
            }
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. Não foi possível recuperar dados." + e.getMessage());
        }
        return isbnsLivros;
    }
}
