package me.dio.banco.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.dio.banco.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String>{}
