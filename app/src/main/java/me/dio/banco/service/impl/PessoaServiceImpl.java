package me.dio.banco.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.banco.model.Endereco;
import me.dio.banco.model.Pessoa;
import me.dio.banco.repository.EnderecoRepository;
import me.dio.banco.repository.PessoaRepository;
import me.dio.banco.service.PessoaService;
import me.dio.banco.service.ViaCepService;

@Service
public class PessoaServiceImpl implements PessoaService{

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Pessoa> buscarTodos(){
        return pessoaRepository.findAll();
    };

    @Override
    public Pessoa buscarPorCPF(String CPF){
        return pessoaRepository.findById(CPF).get();
    };
    
    @Override
    public void inserir(Pessoa p){
        pessoaRepository.save(p);
    }

    @Override
    public void atualizar(String CPF, Pessoa p){
        var pessoa = pessoaRepository.findById(CPF);
        if(pessoa.isPresent()){
            salvarPessoaComCep(pessoa.get());
        }
    }

    @Override
    public void deletar(String CPF){
        pessoaRepository.deleteById(CPF);
    }
    
    private void salvarPessoaComCep(Pessoa pessoa) {
		// Verificar se o Endereco do Cliente já existe (pelo CEP).
		String cep = pessoa.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		pessoa.setEndereco(endereco);
		// Inserir Cliente, vinculando o Endereco (novo ou existente).
		pessoaRepository.save(pessoa);
	}
    

    
}
