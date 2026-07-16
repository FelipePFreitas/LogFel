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
public class Login {

    private Long id;

    private String email;

    private String password;

    private FuncionarioEntity funcionarioEntity;

}
