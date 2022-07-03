package com.ufba.eng.soft.bibliotecapessoal.model.db;

import com.ufba.eng.soft.bibliotecapessoal.model.user.Aluno;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Orientando;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Professor;
import com.ufba.eng.soft.bibliotecapessoal.model.user.TipoUsuario;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioSQLiteOperationsTest {

    @Test
    void getUsuariosPorTipo() {
        //Adiciono tipos diferentes de usuário ao database
        Professor professor1 = new Professor(UUID.randomUUID().toString(), "Jose B.", "jose_b", "joseb123");
        Professor professor2 = new Professor(UUID.randomUUID().toString(), "Jose C.", "jose_c", "josec123");
        Orientando orientando1 = new Orientando(UUID.randomUUID().toString(), "Jose D.", "jose_d", "josed123");
        UsuarioSQLiteOperations.addUsuario(professor1);
        UsuarioSQLiteOperations.addUsuario(professor2);
        UsuarioSQLiteOperations.addUsuario(orientando1);

        //Testo recuperar apenas os professores
        ArrayList<Professor> professores = UsuarioSQLiteOperations.getUsuariosPorTipo(TipoUsuario.PROFESSOR);
        assertTrue(professores.contains(professor1));
        assertTrue(professores.contains(professor2));
        assertTrue(professores.size() >= 2);

        //Testo recuperar apenas os orientandos
        ArrayList<Orientando> orientandos = UsuarioSQLiteOperations.getUsuariosPorTipo(TipoUsuario.ORIENTANDO);
        assertTrue(orientandos.contains(orientando1));
        assertTrue(orientandos.size() >= 1);

        //Removo os usuários previamente cadastrados no batabase
        UsuarioSQLiteOperations.removerUsuarioPorId(professor1.getIdUsuario());
        UsuarioSQLiteOperations.removerUsuarioPorId(professor2.getIdUsuario());
        UsuarioSQLiteOperations.removerUsuarioPorId(orientando1.getIdUsuario());
    }
    @Test
    void atualizarUsuario() {
        //Adiciono tipos diferentes de usuário ao database
        Professor professor1 = new Professor(UUID.randomUUID().toString(), "Jose B.", "jose_b", "joseb123");
        Professor professor2 = new Professor(UUID.randomUUID().toString(), "Jose C.", "jose_c", "josec123");
        UsuarioSQLiteOperations.addUsuario(professor1);
        UsuarioSQLiteOperations.addUsuario(professor2);

        //Testo atualizar um professor
        professor1.setNomeDeUusario("Zezinho");
        professor1.setUserName("ze_pereira");
        UsuarioSQLiteOperations.atualizarUsuario(professor1);
        Professor professorRecuperado = (Professor) UsuarioSQLiteOperations.getUsuarioFromId(professor1.getIdUsuario());
        assertEquals(professor1, professorRecuperado);

        //Removo os usuários previamente cadastrados no database
        UsuarioSQLiteOperations.removerUsuarioPorId(professor1.getIdUsuario());
        UsuarioSQLiteOperations.removerUsuarioPorId(professor2.getIdUsuario());
    }

    @Test
    void removerUsuario() {
        String idUsuario = UUID.randomUUID().toString();
        Aluno aluno = new Aluno(idUsuario, "Abraao", "abraao_01", "1234");
        UsuarioSQLiteOperations.addUsuario(aluno);
        assertNotNull(UsuarioSQLiteOperations.getUsuarioFromId(idUsuario));
        int qtdUsuariosAntes = UsuarioSQLiteOperations.getTodosOsUsuarios().size();

        UsuarioSQLiteOperations.removerUsuarioPorId(idUsuario);
        assertNull(UsuarioSQLiteOperations.getUsuarioFromId(idUsuario));
        int qtdUsuariosDepois = UsuarioSQLiteOperations.getTodosOsUsuarios().size();
        assertEquals(qtdUsuariosAntes - 1, qtdUsuariosDepois);
    }

}