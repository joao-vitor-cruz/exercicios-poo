package com.culinarioo.dao;

import com.culinarioo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class ReceitaDAO {

    @Autowired
    private JdbcTemplate jdbc;

    public void salvar(Receita receita) {
        String sql = "INSERT INTO receita (id, nome, modo_preparo, categoria, tipo_receita) VALUES (?, ?, ?, ?, ?)";
        String tipo = (receita instanceof ReceitaDoce) ? "DOCE" : "SALGADA";
        jdbc.update(sql, receita.getId(), receita.getNome(), receita.getModoPreparo(), receita.getCategoria().toString(), tipo);
    }

    public List<Receita> listarTodas() {
        String sql = "SELECT * FROM receita";
        return listarGenerico(sql);
    }


    public Receita buscarPorId(UUID id) {
        String sql = "SELECT * FROM receita WHERE id = ?";
        List<Receita> resultado = listarGenerico(sql, id);
        if (resultado.isEmpty()) {
            return null;
        }
        return resultado.get(0);
    }

    public void atualizar(UUID id, Receita receita) {
        String sql = "UPDATE receita SET nome = ?, modo_preparo = ?, categoria = ?, tipo_receita = ? WHERE id = ?";
        String tipo = (receita instanceof ReceitaDoce) ? "DOCE" : "SALGADA";

        jdbc.update(sql,
                receita.getNome(),
                receita.getModoPreparo(),
                receita.getCategoria().toString(),
                tipo,
                id
        );
    }

    public void excluir(UUID id) {
        String sql = "DELETE FROM receita WHERE id = ?";
        jdbc.update(sql, id);
    }

    // --- AJUDANTES ---

    // Criei esse método auxiliar para não repetir código no listarTodas e buscarPorId
    private List<Receita> listarGenerico(String sql, Object... args) {
        List<Map<String, Object>> registros = (args.length > 0) ? jdbc.queryForList(sql, args) : jdbc.queryForList(sql);
        List<Receita> receitas = new ArrayList<>();

        for (Map<String, Object> reg : registros) {
            receitas.add(mapearReceita(reg));
        }
        return receitas;
    }

    private Receita mapearReceita(Map<String, Object> reg) {
        UUID id = (UUID) reg.get("id");
        String nome = (String) reg.get("nome");
        String preparo = (String) reg.get("modo_preparo");
        String catStr = (String) reg.get("categoria");
        String tipo = (String) reg.get("tipo_receita");

        Categoria categoria = Categoria.valueOf(catStr);

        Receita receita;
        if ("DOCE".equals(tipo)) {
            receita = new ReceitaDoce(nome, preparo, categoria);
        } else {
            receita = new ReceitaSalgada(nome, preparo, categoria);
        }
        return receita;
    }
}