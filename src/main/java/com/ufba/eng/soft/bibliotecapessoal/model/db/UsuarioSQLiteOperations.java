package com.ufba.eng.soft.bibliotecapessoal.model.db;

import com.ufba.eng.soft.bibliotecapessoal.model.user.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioSQLiteOperations {

    private UsuarioSQLiteOperations() {
    }


    public static boolean addUsuario(UsuarioDoSistema usuario) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            TipoUsuario tipoUsuario;
            if (usuario instanceof Aluno) {
                tipoUsuario = TipoUsuario.ALUNO;
            } else if (usuario instanceof Administrador) {
                tipoUsuario = TipoUsuario.ADMINISTRADOR;
            } else if (usuario instanceof Orientando) {
                tipoUsuario = TipoUsuario.ORIENTANDO;
            } else {
                tipoUsuario = TipoUsuario.PROFESSOR;
            }
            StringBuilder query = new StringBuilder();
            query.append("INSERT INTO USUARIO(ID, NOME, USERNAME, SENHA, DEBITO, EMPRESTIMO, RESERVA, TIPO_USUARIO) VALUES (")
                    .append("'").append(usuario.getIdUsuario()).append("', ")
                    .append("'").append(usuario.getNomeDeUusario()).append("', ")
                    .append("'").append(usuario.getUserName()).append("', ")
                    .append("'").append(usuario.getSenha()).append("', ")
                    .append("'").append(usuario.getDebito()).append("', ")
                    .append("'").append(usuario.getEmprestimo()).append("', ")
                    .append("'").append(usuario.getReserva()).append("', ")
                    .append("'").append(tipoUsuario).append("'")
                    .append(")");
            System.out.println(query);
            return connection.prepareStatement(query.toString()).executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. " + e.getMessage());
            return false;
        }
    }

    public static List<UsuarioDoSistema> getTodosOsUsuarios() {
        ArrayList<UsuarioDoSistema> usuarios = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            String sql = "select * from USUARIO";
            System.out.println(sql);
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                usuarios.add(getUsuarioFromQuery(resultSet));
            }
            System.out.println(usuarios);
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. Não foi possível recuperar dados." + e.getMessage());
        }
        return usuarios;
    }

    public static UsuarioDoSistema getUsuarioFromId(String id) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            String sql = "select * from USUARIO WHERE ID = '" + id + "'";
            System.out.println(sql);
            ResultSet resultSet = connection.prepareStatement(sql).executeQuery();
            return getUsuarioFromQuery(resultSet);
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. " + e.getMessage());
            return null;
        }
    }

    private static UsuarioDoSistema getUsuarioFromQuery(ResultSet resultSet) throws SQLException {
        TipoUsuario tipoUsuario = TipoUsuario.valueOf(resultSet.getString("TIPO_USUARIO"));
        switch (tipoUsuario) {
            case ADMINISTRADOR:
                return new Administrador(
                        resultSet.getString("ID"),
                        resultSet.getString("NOME"),
                        resultSet.getString("USERNAME"),
                        resultSet.getString("SENHA"),
                        resultSet.getString("DEBITO"),
                        resultSet.getString("EMPRESTIMO"),
                        resultSet.getString("RESERVA")
                );
            case ALUNO:
                return new Aluno(
                        resultSet.getString("ID"),
                        resultSet.getString("NOME"),
                        resultSet.getString("USERNAME"),
                        resultSet.getString("SENHA"),
                        resultSet.getString("DEBITO"),
                        resultSet.getString("EMPRESTIMO"),
                        resultSet.getString("RESERVA")
                );
            case ORIENTANDO:
                return new Orientando(
                        resultSet.getString("ID"),
                        resultSet.getString("NOME"),
                        resultSet.getString("USERNAME"),
                        resultSet.getString("SENHA"),
                        resultSet.getString("DEBITO"),
                        resultSet.getString("EMPRESTIMO"),
                        resultSet.getString("RESERVA")
                );
            case PROFESSOR:
                return new Professor(
                        resultSet.getString("ID"),
                        resultSet.getString("NOME"),
                        resultSet.getString("USERNAME"),
                        resultSet.getString("SENHA"),
                        resultSet.getString("DEBITO"),
                        resultSet.getString("EMPRESTIMO"),
                        resultSet.getString("RESERVA")
                );
        }
        System.out.println("LOG.warn: tipo de usuário desconhecido: " + tipoUsuario);
        return null;
    }

    public static boolean removerUsuarioPorId(String id) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            ReservaSQLiteOperations.removerTodasAsReservasParaUsuario(id);
            EmprestimoSQLiteOperations.removerTod0sOsEmprestimosParaUsuario(id);
            String sql = "delete from USUARIO WHERE ID = '" + id + "'";
            System.out.println(sql);
            return connection.prepareStatement(sql).executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. " + e.getMessage());
            return false;
        }
    }

    public static UsuarioDoSistema getUsuarioFromNome(String nome) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            String sql = "select * from USUARIO WHERE NOME LIKE '%" + nome + "%' LIMIT 1";
            System.out.println(sql);
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            return getUsuarioFromQuery(resultSet);
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no getUsuarioFromNome no banco de dados da aplicação. " + e.getMessage());
            return null;
        }
    }

    public static <T> ArrayList<T> getUsuariosPorTipo(TipoUsuario tipoUsuario) {
        ArrayList<T> usuariosEncontrados = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            String sql = "select * from USUARIO WHERE TIPO_USUARIO = '" + tipoUsuario.name() + "'";
            System.out.println(sql);
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                usuariosEncontrados.add((T) getUsuarioFromQuery(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. Não foi possível recuperar dados." + e.getMessage());
        }
        return usuariosEncontrados;
    }

    public static void atualizarUsuario(UsuarioDoSistema usuario) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:persibi.db")) {
            TipoUsuario tipoUsuario;
            if (usuario instanceof Aluno) {
                tipoUsuario = TipoUsuario.ALUNO;
            } else if (usuario instanceof Administrador) {
                tipoUsuario = TipoUsuario.ADMINISTRADOR;
            } else if (usuario instanceof Orientando) {
                tipoUsuario = TipoUsuario.ORIENTANDO;
            } else {
                tipoUsuario = TipoUsuario.PROFESSOR;
            }
            StringBuilder query = new StringBuilder();
            query.append("update USUARIO set ")
                    .append("NOME = '").append(usuario.getNomeDeUusario()).append("', ")
                    .append("USERNAME = '").append(usuario.getUserName()).append("', ")
                    .append("SENHA = '").append(usuario.getSenha()).append("', ")
                    .append("DEBITO = '").append(usuario.getDebito()).append("', ")
                    .append("EMPRESTIMO = '").append(usuario.getEmprestimo()).append("', ")
                    .append("RESERVA = '").append(usuario.getReserva()).append("', ")
                    .append("TIPO_USUARIO = '").append(tipoUsuario).append("' ")
                    .append("where ID = '").append(usuario.getIdUsuario()).append("'");
            System.out.println(query);
            connection.prepareStatement(query.toString()).executeUpdate();
        } catch (SQLException e) {
            System.out.println("LOG.error: Falha no banco de dados da aplicação. " + e.getMessage());
        }
    }
}
