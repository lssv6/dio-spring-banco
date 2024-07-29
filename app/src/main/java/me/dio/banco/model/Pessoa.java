package me.dio.banco.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Pessoa{
    @Id
    @Getter@Setter
    private String CPF;
    @Getter@Setter
    private String nome;
    @Getter@Setter
    private LocalDate nascimento;
    @Getter@Setter
    private boolean sexo;
    @ManyToOne
    @Getter@Setter
    private Endereco endereco;
}
