/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.model.product;

import java.util.Arrays;
import java.util.Optional;

/**
 *
 * @author joand
 */
public enum GeneroLivro {
    INFANTIL("INFANTIL"),
    PARADIDATICO("PARADIDATICO"),
    DIDATICO("DIDATICO"),
    INFANTO_JUVENIL("INFANTO-JUVENIL"),
    FANTASIA("FANTASIA"),
    POLICIAL("POLICIAL"),
    BIOGRAFIA("BIOGRAFIA"),
    RELIGIOSO("RELIGIOSO"),
    AUTOAJUDA("AUTOAJUDA"),
    DESCONHECIDO("DESCONHECIDO");

    private final String value;

    GeneroLivro(String value) {
        this.value = value;
    }

    public static Optional<GeneroLivro> getFromValue(String value) {
        return Arrays.stream(GeneroLivro.values()).filter(genero -> genero.name().equalsIgnoreCase(value)).findFirst();
    }
}
