package com.ufba.eng.soft.bibliotecapessoal.model.db;

import java.sql.*;

public class SQLiteJDBCDriverConnection {

    private SQLiteJDBCDriverConnection() {

    }

    public static void connect() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {

            System.out.println("LOG.info: Conexão com banco de dados realizada com sucesso");

            Statement statement = connection.createStatement();

//            statement.execute("DROP TABLE LIVROS");
//            statement.execute("DROP TABLE USUARIO");
//            statement.execute("DROP TABLE RESERVA");
            // criando a tabela livros
            statement.execute("CREATE TABLE IF NOT EXISTS LIVROS( " +
                    "NOME VARCHAR, " +
                    "ISBN INTEGER PRIMARY KEY, " +
                    "COD_BARRAS VARCHAR, " +
                    "AUTOR_ID INTEGER, " +
                    "AUTOR_NOME VARCHAR, " +
                    "GENERO_LIVRO VARCHAR, " +
                    "TOTAL_COPIAS INTEGER, " +
                    "EMPRESTADO INTEGER, " +
                    "RESERVADO INTEGER" +
                    ")");

            statement.execute("CREATE TABLE IF NOT EXISTS RESERVA(" +
                    "ID VARCHAR PRIMARY KEY, " +
                    "ISBN INTEGER, " +
                    "ID_USUARIO VARCHAR, " +
                    "CONSTRAINT isbn_user UNIQUE(ISBN, ID_USUARIO))");

            statement.execute("CREATE TABLE IF NOT EXISTS EMPRESTIMO(" +
                    "ID VARCHAR PRIMARY KEY, " +
                    "ISBN INTEGER, " +
                    "ID_USUARIO VARCHAR, " +
                    "CONSTRAINT isbn_user UNIQUE(ISBN, ID_USUARIO))");

            statement.execute("CREATE TABLE IF NOT EXISTS USUARIO(" +
                    "ID VARCHAR PRIMARY KEY, " +
                    "NOME VARCHAR, " +
                    "USERNAME VARCHAR, " +
                    "SENHA VARCHAR, " +
                    "DEBITO VARCHAR, " +
                    "EMPRESTIMO VARCHAR, " +
                    "RESERVA VARCHAR, " +
                    "TIPO_USUARIO VARCHAR" +
                    ")");

        } catch (SQLException e) {
            System.out.println("LOG.error: Falha ao se conectar com banco de dados da aplicação. " + e.getMessage());
        }
    }
}