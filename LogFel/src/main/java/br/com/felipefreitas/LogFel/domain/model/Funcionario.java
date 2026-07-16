package br.com.felipefreitas.LogFel.domain.model;


import br.com.felipefreitas.LogFel.infra.adapters.output.database.entity.CargoEntity;
import br.com.felipefreitas.LogFel.infra.adapters.output.database.entity.RoleEntity;
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

    private String email;

    private String endereco;

    private String numero;

    private String cep;

    private String bairro;

    private String cidade;

    private String estado;

    private RoleEntity roleEntity;

    private CargoEntity cargo;
}
