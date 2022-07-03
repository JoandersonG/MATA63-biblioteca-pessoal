
package com.ufba.eng.soft.bibliotecapessoal.model.user;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import java.util.ArrayList;


import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class UsuarioDoSistema {
    private String idUsuario;
    private String nomeDeUusario;
    private String userName;
    private String senha;
    private String debito;
    private String emprestimo;
    private String reserva;

    public UsuarioDoSistema(String idUsuario, String nomeDeUusario, String userName, String senha) {
        this.idUsuario = idUsuario;
        this.nomeDeUusario = nomeDeUusario;
        this.userName = userName;
        this.senha = senha;
        this.debito = "Não";
        this.emprestimo = "Não";
        this.reserva = "Não";
    }

}


