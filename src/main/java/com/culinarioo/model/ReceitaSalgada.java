package com.culinarioo.model;

public class ReceitaSalgada extends Receita {

    public ReceitaSalgada(String nome, String modoPreparo, Categoria categoria) {
        super(nome, modoPreparo, categoria);
    }

    @Override
    public String getTipoEtiqueta() {
        return "Salgado";
    }
}