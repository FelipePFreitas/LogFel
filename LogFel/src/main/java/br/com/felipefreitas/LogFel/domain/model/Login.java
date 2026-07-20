package br.com.felipefreitas.LogFel.domain.model;

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

    private Funcionario funcionario;

}
