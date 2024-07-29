package me.dio.banco.service;

import me.dio.banco.model.Pessoa;

public interface PessoaService{
    public Iterable<Pessoa> buscarTodos();

    public Pessoa buscarPorCPF(String CPF);

    public void inserir(Pessoa pessoa);

    public void atualizar(String CPF, Pessoa p);

    public void deletar (String CPF);
}

