package br.com.felipefreitas.LogFel.infra.adapters.input.rest.dto.login;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {

    @NotBlank(message = "Não poder ser nulo e nem em branco")
    @Email(message = "Email informado não possui o formato válido")
    private String email;

    @NotBlank(message = "Não poder ser nulo e nem em branco")
    private String password;

    @NotNull(message = "Os dados do funcionário são obrigatórios")
    @Valid // Faz o Spring validar os campos do FuncionarioRequestDTO também!
    private FuncionarioRequestDTO funcionario;


}