package me.dio.banco.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Endereco{
    @Id
    @Getter@Setter
    private String cep;
    @Getter@Setter
    private String logradouro;
    @Getter@Setter
    private String complemento;
    @Getter@Setter
    private String unidade;
    @Getter@Setter
    private String bairro;
    @Getter@Setter
    private String localidade;
    @Getter@Setter
    private String UF;
    @Getter@Setter
    private String ibge;
    @Getter@Setter
    private String gia;
    @Getter@Setter
    private String ddd;
    @Getter@Setter
    private String siafi;
}

