
package com.ufba.eng.soft.bibliotecapessoal.model.user;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import java.util.ArrayList;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
public class Administrador extends UsuarioDoSistema {
    
    public Administrador(String idUsuario, String nomeDeUusario, String userName, String senha) {
        super(idUsuario, nomeDeUusario, userName, senha);
    }

    public Administrador(String idUsuario, String nomeDeUusario, String userName, String senha, String debito, String emprestimo, String reserva) {
        super(idUsuario, nomeDeUusario, userName, senha, debito, emprestimo, reserva);
    }
    
}
