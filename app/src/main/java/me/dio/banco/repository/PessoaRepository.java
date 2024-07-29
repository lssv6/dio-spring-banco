package me.dio.banco.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.dio.banco.model.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, String> {}

