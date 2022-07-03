package com.ufba.eng.soft.bibliotecapessoal.model.db;

import org.sqlite.SQLiteErrorCode;
import org.sqlite.SQLiteException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReservaSQLiteOperations {

    private ReservaSQLiteOperations() {
    }


    static void inserirReservaSeNaoExistir(int isbn, String idUsuario) throws SQLException {
        inserirReservaSeNaoExistir(UUID.randomUUID().toString(), isbn, idUsuario);
    }
    static void inserirReservaSeNaoExistir(String id, int isbn, String idUsuario) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO RESERVA(ID, ISBN, ID_USUARIO) VALUES ('"
                    + id + "', " + isbn + ", '" + idUsuario + "')";
            System.out.println(sql);
            statement.execute(sql);
        } catch (SQLiteException e) {
            if (e.getResultCode() != SQLiteErrorCode.SQLITE_CONSTRAINT) {
                System.out.println("LOG.error: Falha no banco de dados da aplicação. " + e.getMessage());
            }
        }
    }

    public static List<String> getTodasAsReservas() {
        ArrayList<String> reservas = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            String sql = "select * from RESERVA";
            System.out.println(sql);
            ResultSet resultSet = connection.prepareStatement(sql).executeQuery();
            while (resultSet.next()) {
                reservas.add(resultSet.getInt("ISBN") + " : " + resultSet.getString("ID_USUARIO"));
            }
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. Não foi possível recuperar dados." + e.getMessage());
        }
        return reservas;
    }

    public static void remover(int isbn, String idUsuario) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            String sql = "delete from RESERVA where ISBN = " + isbn + ", ID_USUARIO = '" + idUsuario + "'";
            System.out.println(sql);
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. Não foi possível recuperar dados." + e.getMessage());
        }
    }

    public static void removerTodasAsReservasParaLivro(String isbn) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            String sql = "delete from RESERVA where ISBN = " + isbn;
            System.out.println(sql);
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. Não foi possível recuperar dados." + e.getMessage());
        }
    }

    public static void removerTodasAsReservasParaUsuario(String idUsuario) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            String sql = "delete from RESERVA where ID_USUARIO = '" + idUsuario + "'";
            System.out.println(sql);
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. Não foi possível recuperar dados." + e.getMessage());
        }
    }

    public static List<String> getTodasAsReservasParaUsuario(String id) {
        ArrayList<String> isbnsLivros = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            String sql = "select * from RESERVA where ID_USUARIO = '" + id + "'";
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
