package com.culinarioo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Receita {
    
    private UUID id;
    private String nome;
    private List<Ingrediente> ingredientes = new ArrayList<>();
    private String modoPreparo;
    private Categoria categoria;

    public Receita(String nome, String modoPreparo, Categoria categoria) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.modoPreparo = modoPreparo;
        this.categoria = categoria;
    }

    public abstract String getTipoEtiqueta();

    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public List<Ingrediente> getIngredientes() { return ingredientes; }
    public void setIngredientes(List<Ingrediente> ingredientes) { this.ingredientes = ingredientes; }
    public Categoria getCategoria() { return categoria; }
    public String getModoPreparo() { return modoPreparo; }
}