package me.dio.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.dio.banco.model.Pessoa;
import me.dio.banco.repository.PessoaRepository;

@RestController
public class PessoaController{

    @Autowired
    private PessoaRepository repository;

    @GetMapping("/pessoas")
    public Iterable<Pessoa> getAll(){
        return repository.findAll();
    }

    @GetMapping("/pessoas/{id}")
    public Pessoa getById(@PathVariable("id") String cpf){
        return repository.findById(cpf).get();
    }

    @PostMapping("/pessoas")
    public void newPessoa(@RequestBody Pessoa p){
        repository.save(p);
    }

    @DeleteMapping("/pessoas/{id}")
    public void deletePessoa(@PathVariable("id") String cpf){
        repository.deleteById(cpf);
    }
}

