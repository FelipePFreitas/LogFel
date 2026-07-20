package br.com.felipefreitas.LogFel.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String senha;

    private String endereco;

    private String numero;

    private String cep;

    private String bairro;

    private String cidade;

    private String estado;

    private Role role;

    private Cargo cargo;
}
