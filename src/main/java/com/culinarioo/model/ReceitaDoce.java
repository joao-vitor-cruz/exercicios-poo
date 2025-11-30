package com.culinarioo.model;

public class ReceitaDoce extends Receita {
    
    public ReceitaDoce(String nome, String modoPreparo, Categoria categoria) {
        super(nome, modoPreparo, categoria);
    }

    @Override
    public String getTipoEtiqueta() {
        return "Doce";
    }
}