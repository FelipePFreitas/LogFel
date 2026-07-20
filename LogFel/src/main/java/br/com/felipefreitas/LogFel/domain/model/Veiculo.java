package br.com.felipefreitas.LogFel.domain.model;

import br.com.felipefreitas.LogFel.infra.adapters.output.database.entity.FuncionarioEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    private Long id;

    private String modelo;

    private String ano;

    private String tipo;

    private boolean sendoUsado = false;

    private Funcionario funcionario;

}
