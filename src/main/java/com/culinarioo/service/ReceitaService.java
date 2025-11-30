package com.culinarioo.service;

import com.culinarioo.dao.ReceitaDAO;
import com.culinarioo.model.Receita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaDAO receitaDAO;

    public List<Receita> listarTodas() {
        return receitaDAO.listarTodas();
    }

    public void salvar(Receita receita) {
        receitaDAO.salvar(receita);
    }

    public void excluir(UUID id) {
        receitaDAO.excluir(id);
    }


    public Receita buscarPorId(UUID id) {
        return receitaDAO.buscarPorId(id);
    }

    public void atualizar(UUID id, Receita receita) {
        receitaDAO.atualizar(id, receita);
    }
}